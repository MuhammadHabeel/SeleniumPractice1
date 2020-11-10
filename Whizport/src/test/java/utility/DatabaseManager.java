package utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class DatabaseManager {
	

	
	Connection connection;
	Statement statement;
	String query;
	ResultSet result;
	DatabaseMetaData databaseInfo;
	ResultSetMetaData resultSetmetaData;
	String tableName;	
	String columnName;
	
	//SQL Data type codes
	    String  Negative7IsActualDataTypeFor ;
	    String  Negative6CodeIsActualDataTypeFor;
	    String  Negative5CodeIsActualDataTypeFor;
	    String  Negative4CodeIsActualDataTypeFor; 
	    String  Negative3CodeIsActualDataTypeFor;
	    String  Negative2CodeIsActualDataTypeFor;
	    String  Negative1CodeIsActualDataTypeFor;
	    String _0CodeIsActualDataTypeFor;
	    String _1CodeIsActualDataTypeFor;
	    String _2CodeIsActualDataTypeFor;
	    String _3CodeIsActualDataTypeFor;
	    String _4CodeIsActualDataTypeFor;
	    String _5CodeIsActualDataTypeFor;
	    String _6CodeIsActualDataTypeFor;
	    String _7CodeIsActualDataTypeFor;
	    String _8CodeIsActualDataTypeFor;
	    String _91CodeIsActualDataTypeFor;
	    String _92CodeIsActualDataTypeFor;
	    String _93CodeIsActualDataTypeFor;
	    String _12CodeIsActualDataTypeFor;
	
	    
	    /**
	     * this method is use to connect with back-end (database)
	     * @return - the database connection
	     * @throws SQLException
	     * @throws ClassNotFoundException
	     */
		public DatabaseManager createConnection() throws SQLException, ClassNotFoundException {

		     try {
		        
		    	 //This is used to Register the Database connectivity driver with the class.
		         Class.forName(BasePage.configProperty.readProperty("DriverName"));
		        	  
		         //This if condition is used to select the environment based on the user selection from the jenkins 
		        if(System.getProperty("environmentT").equalsIgnoreCase("test")) {

		        			//This is used to connect with the database in specific database environment. change database detail in the Config.properties file.
		        		  connection = DriverManager.getConnection(BasePage.configProperty.readProperty("DatabaseTestURL")
		        				  								   ,BasePage.configProperty.readProperty("DatabaseTestUserName")
		        				  								   ,BasePage.configProperty.readProperty("DatabaseTestPassword"));
 		        	  }
		        
		        	//This if condition is used to select the environment based on the user selection from the jenkins 
		        	  else if(System.getProperty("environmentT").equalsIgnoreCase("val")) 
						{
		        		  
		        		//This is used to connect with the database in specific database environment. change database detail in the Config.properties file.
		        		  connection = DriverManager.getConnection(BasePage.configProperty.readProperty("DatabaseValtURL")
		        				  								  ,BasePage.configProperty.readProperty("DatabaseValUserName")
		        				  								  ,BasePage.configProperty.readProperty("DatabaseValPassword"));
			
						} else {
							 Reporter.addStepLog("Please provide the correct Evironment Name, it should be among following name -Test, Val or Prod");
							 System.out.println("Please provide the correct Evironment Name, it should be among following name -Test, Val or Prod");
						 }  
		        	  
		        	  	        	  
		          } 
		          catch (SQLException e)
		          
		          {
		              for(Throwable ex : e)
		            	  
			              {
			                  System.err.println("Error occurred " + ex);
			              }
		             
		              e.printStackTrace();
		          }
		          

		     	//This if condition is used to printing the message in the console 
		          if (connection != null)
		          {
		              System.out.println("Connected to database!");
		          } 
		          else 
		          {
		              System.out.println("Failed to make connection!");
		          }
			
			
	        return new DatabaseManager();
	    }
		
		
		
		
		
		
		
/**
 * This method is used to create the query
 * @param query - here type the SQl query
 * @return
 * @throws SQLException
 */
		 public DatabaseManager createQuery(String query) throws SQLException {

			 	 statement = connection.createStatement();
	             this.query = query;

		        return new DatabaseManager();
		    }
	
	
		 
/**
 * This method is used to run a query 
 * @return
 * @throws SQLException
 */
		 public DatabaseManager executeQuery() throws SQLException {
			 
			 	this.result = statement.executeQuery(query);
			 
		        return new DatabaseManager();
		    }
		 
		 
	
/**
 * This method is used to check the xml file.
 * @param xmlNode
 * @param objectIndexNumber
 * @return
 * @throws SQLException
 */
		 public DatabaseManager verifyXML(String xmlNode, int objectIndexNumber) throws SQLException {
			 
			 while(result.next()) {
				 
				  String actualObject = result.getObject(objectIndexNumber).toString().trim();
				  
				   
				   assertEquals(xmlNode, actualObject);
				   
				   Reporter.addStepLog(actualObject +" = "+xmlNode);	  
			 }
			 
			 
			 return new DatabaseManager();
		 }
		 
		 
		 
		 
/**This method is used to get table names from the database in the list.
 *  
 * @return
 * @throws SQLException
 */
		 public List<String> getTableNames() throws SQLException {
			 
		
			  DatabaseMetaData md = connection.getMetaData();
	          ResultSet rs = md.getTables(null, null, "%", null);
	          
	          List<String> namesList = new ArrayList<String>();
	          
	          while (rs.next()) {
	        	  
	        	  namesList.add(rs.getString(3));
	    
	          }
		
	          return namesList;
		 }
		 
		
		 
/**
 * This method is used to get the Store Procedure names in the list
 * @return
 * @throws SQLException
 */
		 
		 public List<String> getStoreProcedureNames() throws SQLException {
			 
				
			  DatabaseMetaData meta = connection.getMetaData();
	          ResultSet res = meta.getProcedures(null, null, null); 
	         
	          List<String> namesList = new ArrayList<String>();
	          
	          while (res.next()) {
	        	  
	        	  namesList.add(res.getString("PROCEDURE_NAME"));
	    
	          }
		
	          return namesList;
		 }
		 
		 
		 
/**
 * This method is used to verify a record in the table 
 * @param columnIndexNumber
 * @param name
 * @return
 * @throws SQLException
 */
		 
	 public DatabaseManager assertRecords(int columnIndexNumber,String name) throws SQLException {
		       
		

			   while (result.next())

			   		{
	                 String  myName = result.getObject(columnIndexNumber).toString();
	             
			           Assert.assertEquals(name,myName);
			          System.out.println(name);
			          System.out.println(myName);
			         Reporter.addStepLog(name);
			        }
			   
		         return new DatabaseManager();

		   }
		 
		   
	 
	 
/**
 * This method is used to print a record based on the column index number
 * @param columnIndexNumber
 * @return
 * @throws SQLException
 */
	 public Object printRecord(int columnIndexNumber) throws SQLException {
	       
			
		  while (result.next())

	   		{
            String myName = result.getObject(columnIndexNumber).toString();
       
           return myName;
	        }
		 
	         return null;

	   }
	 
	 
	 
/**
 * This method is used to close the database connection
 * @return
 * @throws SQLException
 */
		   
		   public DatabaseManager closeConnection() throws SQLException {
			   
			   connection.close();
			   
		        return this;
		    }
		 
		 
/**
 * This method is used to get table and column name 
 * @param tableName
 * @param columnName
 * @return
 * @throws SQLException
 */
		 
		   public DatabaseManager getTableAndFieldName(String tableName, String columnName) throws SQLException {
			  
			   DatabaseMetaData databaseInfo= connection.getMetaData();
			   this.columnName =columnName;
			   this.tableName=tableName;
			   result =databaseInfo.getColumns(null, null, this.tableName, this.columnName);

	        	return new DatabaseManager();
		   	}
		   
		   
		   
		   
		   
		   
		   /**
		    * This method is used to run the store procedures
		    * @param storeProcedureName
		    * @return
		    * @throws SQLException
		    */
		   
		   public DatabaseManager executeStoreProcedure(String storeProcedureName ) throws SQLException {
			   String storeProcedureCall = "{call "+storeProcedureName+"}";
		          
		          statement = connection.prepareCall(storeProcedureCall);
			           
		    	   
		    	   CallableStatement storeProcedure=connection.prepareCall(storeProcedureCall);
		    	  
		    	   this.result = storeProcedure.executeQuery();
			   
			  return new DatabaseManager();
		   }
		   
		   
		   /**
		    * This method is used to return the store procedure column names 
		    * @param storeProcedureName
		    * @param columnIndexNumber
		    * @return
		    * @throws SQLException
		    */
		   
		   public String getStoreProcedureColumName(int columnIndexNumber) throws SQLException {
			   
		    	   ResultSetMetaData rsmd = result.getMetaData(); 
		    	   
		    	
		    	         String columnName = rsmd.getColumnName(columnIndexNumber).trim();   
		    	           // System.out.println("columnName: " + columnName);
		    	return  columnName;        
		   }
		   
		   
		  /**
		   * 
		   *  This method is used to print first record of a store Procedure
		   * @param connection - provide database connection
		   * @param storeProcedureName - store procedure name
		   * @throws SQLException
		   */
		   
		   public void rows(String storeProcedureName) throws SQLException {
				
				
				CallableStatement proc_stmt = connection.prepareCall("{ call "+storeProcedureName+" }");

		        ResultSet rs = proc_stmt.executeQuery();

		     ResultSetMetaData rsmd = rs.getMetaData();
		     int columnsNumber = rsmd.getColumnCount();

				
				     if(rs.next()) {
				         for(int i = 1; i < columnsNumber; i++)
				      	   
				            System.out.print(rs.getString(i) + ",");
				         System.out.println();
				   }
			
			}
			
			
			/**
			 * this method is used to return the cell based on column index as object
			 * @param connection
			 * @param storeProcedureName
			 * @param columnByIndex
			 * @return
			 * @throws SQLException
			 */
	
			public  Object getStoreProcedureRows(String storeProcedureName,int columnByIndex) throws SQLException {
				
				
				CallableStatement proc_stmt = connection.prepareCall("{ call "+storeProcedureName+" }");

		        ResultSet rs = proc_stmt.executeQuery();

				     if(rs.next()) {
				       
				      	   
				      return rs.getObject(columnByIndex);
				        
				   }
				     return null;
			}
		   

/**
 * This method is used to check if a column is primary key in the table
 * @param isPrimaryKey
 * @return
 * @throws SQLException
 */
		   
		   public DatabaseManager verifyIfAColumnIsPrimaryKey(String isPrimaryKey) throws SQLException {
				  
			 DatabaseMetaData databaseInfo= connection.getMetaData();
			   
			   result=databaseInfo.getPrimaryKeys(null, null, this.tableName);
			   
			   
			   while(result.next()) {
			   		
				  
						  if(!result.getString("COLUMN_NAME").equals(this.columnName)) {
							  
								Reporter.addStepLog("is Primary Key  -  "+isPrimaryKey);
						  }else {
							  
							  Reporter.addStepLog("is Primary Key  -  YES");
							  assertTrue(false);
							 
						  }

			 		
				   	}
			  
	        	return new DatabaseManager();
		   	}
		   
		   
		   
/**
 * This method is used to check the column types, size, isNullAccepted ad isAutoIncremented or not.  
 * @param expectedcolumnName
 * @param expectedDataType
 * @param expectedColumnSize
 * @param isNullAccepted
 * @param isAutoIncremented
 * @return
 * @throws SQLException
 */
		   public DatabaseManager assertTheColumnNameAndDetails(String expectedcolumnName, String expectedDataType,String expectedColumnSize,String isNullAccepted,String isAutoIncremented) throws SQLException {
		       			   
	        	while (result.next())
	        	{
	        		
	        		
	        		String actualColumnName=result.getString("COLUMN_NAME");
	        		String actualColumnDataType = result.getString("DATA_TYPE");
	        	    String actualColumnSize = result.getString("COLUMN_SIZE");
	        	    String actualColumnIsNullable = result.getString("IS_NULLABLE");
	        	    
	        		Assert.assertEquals(expectedcolumnName,actualColumnName);
	        		Assert.assertEquals(expectedDataType,sqlDataTypeCodeConversation(actualColumnDataType));
	        		Assert.assertEquals(expectedColumnSize,actualColumnSize);
	        		Assert.assertEquals(isNullAccepted,actualColumnIsNullable);
	        	
	        		Reporter.addStepLog("Database Vs Data Dictionary");
	        		Reporter.addStepLog("Column Details :"+actualColumnName);
	        		Reporter.addStepLog("Data Types: "+ sqlDataTypeCodeConversation(actualColumnDataType) +"  -  "+expectedDataType);
	        		Reporter.addStepLog("Field Size: "+actualColumnSize+"  -  "+expectedColumnSize);
	        		Reporter.addStepLog("Allow Nulls: "+actualColumnIsNullable+"  -  "+isNullAccepted);
	        		
	        	}
				
		        return new DatabaseManager();
		    } 

		   

/**
 * This method is used to verify the expected column name in the table
 * @param expectedcolumnName
 * @return
 * @throws SQLException
 */
		   public DatabaseManager assertTheColumnNameAndDetails2(String expectedcolumnName) throws SQLException {
   			   
	        	while (result.next())
	        	{
	        		
	        		
	        		String actualColumnName=result.getString("COLUMN_NAME");
	        		
	        	    
	        		Assert.assertEquals(expectedcolumnName,actualColumnName);
	        
	        	
	        		Reporter.addStepLog("Database Vs Data Dictionary");
	        		Reporter.addStepLog("Column Details :"+actualColumnName);
	        	
	        		
	        	}
				
		        return new DatabaseManager();
		    } 

		   
		   
/**
 * This method is used as helper method to convert the SQL dataType to Java data types.
 * @param sqlCode
 * @return
 */
		   
		   private  String sqlDataTypeCodeConversation(String sqlCode) {
			   
		   	    _12CodeIsActualDataTypeFor="VARCHAR"; 
        	   Negative7IsActualDataTypeFor ="BIT";
        	   Negative6CodeIsActualDataTypeFor="TINYINT";
        	   Negative5CodeIsActualDataTypeFor="BIGINT";
        	   Negative4CodeIsActualDataTypeFor="LONGVARBINARY"; 
        	   Negative3CodeIsActualDataTypeFor="VARBINARY";
        	   Negative2CodeIsActualDataTypeFor="BINARY";
        	   Negative1CodeIsActualDataTypeFor="LONGVARCHAR";
        	   _0CodeIsActualDataTypeFor="NULL";
        	   _1CodeIsActualDataTypeFor="CHAR";
        	   _2CodeIsActualDataTypeFor="NUMERIC";
        	   _3CodeIsActualDataTypeFor="DECIMAL";
        	   _4CodeIsActualDataTypeFor="INTEGER";
        	   _5CodeIsActualDataTypeFor="SMALLINT";
        	   _6CodeIsActualDataTypeFor="FLOAT";
        	   _7CodeIsActualDataTypeFor="REAL";
        	   _8CodeIsActualDataTypeFor="DOUBLE";
        	   _91CodeIsActualDataTypeFor="DATE";
        	   _92CodeIsActualDataTypeFor="TIME";
        	   _93CodeIsActualDataTypeFor="TIMESTAMP";
			   
        	    if(sqlCode.equals("12")) {
        	    	return _12CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("4")) {
        	    	return _4CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("91")) {
        	    	return _91CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("8")) {
        	    	return _8CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("1")) {
        	    	return _1CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("6")) {
        	    	return _6CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("92")) {
        	    	return _92CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("93")) {
        	    	return _93CodeIsActualDataTypeFor;
        	    }
			   
        	    else if(sqlCode.equals("3")) {
        	    	return _3CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("5")) {
        	    	return _5CodeIsActualDataTypeFor;
        	    }
        	    else if(sqlCode.equals("2")) {
        	    	return _2CodeIsActualDataTypeFor;
        	    }else {
        	    	
        	    	Reporter.addStepLog("Please provide the the correct the generic code for SQL data types");
        	    	System.out.println("Please provide the the correct the generic code for SQL data types");
        	    }
			   
			   
			   
			   return null;
		   }
}