package WeatherInfo;


import java.util.Date;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class WriteToMongo {

  
   public WriteToMongo() {
		super();
		// TODO Auto-generated constructor stub
	}

static String[] upisiZapisOGradu(String jsonzapis) {
      
      

       try {
           // Connecting To The MongoDb Server Listening On A Default Port (i.e. 27017).
           MongoClient mongoClntObj = new MongoClient("localhost", 27017);

           // Get MongoDb Database. If The Database Doesn't Exists, MongoDb Will Automatically Create It For You
           DB dbObj = mongoClntObj.getDB("mongodbdemo");

           // Get MongoDb Collection. If The Collection Doesn't Exists, MongoDb Will Automatically Create It For You
           DBCollection kolekcija = dbObj.getCollection("zapisi2");

           /**** INSERT OPERATION ****/
           // Creating The MongoDb Documents To Store Key-Value Pair
           BasicDBObject documentObj;
           String address[];
          
               documentObj = new BasicDBObject();              
               DBObject dbObject = (DBObject)JSON.parse(jsonzapis);
   			
               kolekcija.insert(dbObject);

          

           // Get MongoDb Collections Count
           System.out.println("Total Number Of MongoDb Collection?=  "+ kolekcija.getCount());

           /**** READ OPERATION ****/
           // ------------------------------------ Get All Documents ------------------------------------
           DBCursor cursorObj = kolekcija.find();
           try {
               while(cursorObj.hasNext()) {
                   System.out.println(cursorObj.next());
               }
           } finally {
               cursorObj.close();
           }

          
           /**** DELETE OPERATION ****/
           // Dropping Collection From The MongoDb Database
    //       if(dbObj.collectionExists("jcg")) {
    //           collectionObj.drop();
    //       }
    //       System.out.println("\n Collection Successfully Dropped From The Database");

           // Dropping The MongoDb Database
    //       dbObj.dropDatabase();
    //       System.out.println("\n Database Successfully Dropped");

           /**** DONE ****/
           mongoClntObj.close();
           
           System.out.println("\n! Demo Completed !");
       } catch (MongoException mongoExObj) {
           mongoExObj.printStackTrace();
       }
	return null;
   }
}