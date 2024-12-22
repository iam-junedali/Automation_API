package apiTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Copies_Count {

    //@Test
    public void Match_copies_count() {

        int size,course_price,count =0,purchaseAmount;

        JsonPath js = new JsonPath(Payloads.Courses());

        size = js.getInt("courses.size()");

        for (int i=0; i<=size-1; i++) {
            course_price = js.getInt("courses[" + i + "].price");
            count = course_price + count;
        }
        System.out.println(count);

        purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        Assert.assertEquals(count,purchaseAmount);

    }
}
