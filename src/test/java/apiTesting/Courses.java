package apiTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Courses {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(Payloads.Courses());

        //Get the count of the courses.
        int size = js.getInt("courses.size()");
        System.out.println(size);

        //Print the purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        //Print the first course Title
        String Course_Title = js.getString("courses[0].title");
        System.out.println(Course_Title);

        //Print the Last course title
        String Last_Course_Title = js.getString("courses[2].title");
        System.out.println(Last_Course_Title);

        //Print all course titles and copies sold
        for (int i=0; i<=size-1; i++) {
            String course_Title = js.getString("courses["+i+"].title");
            String course_Copies = js.getString("courses["+i+"].copies");
            System.out.println("Course Title is " + course_Title + " " + "and Number of copies sold are " + course_Copies);
            //Print the number of copies sold for RPA course.
            if (course_Title.equalsIgnoreCase("RPA")){
                String RPA_Copies = js.getString("courses["+i+"].copies");
                System.out.println("Total Number of copies sold for RPA course is "+RPA_Copies);
            }
        }
    }
}
