# singlestoneDemo
Take home exercise for SingleStone Back End Java

# Running
You probably already know this, but you can start the app by running `mvnw spring-boot:run` from the root/

# Testing
I am a big advocate of thorough testing, unit, integration, and more. But in this case, I don't think there's much to test with Unit Tests. There's plenty to test wih Integration tests, and with @DataJpaTest making repository testing much easier than it used to be, I would normally have tests for that.

I did add the Postman collection that I was using to test the endpoints, in case that helps. It's under /src/test/resources.

# Call-list
In the real world, and with performance in mind, this would probably be better to simply do the sort in the query, instead of processing the whole collection again at the service layer. The SQL would be a simple join. But with the sort and filter fields on different tables, I didn't know how to do that with the JPA query methods. Maybe it just needed to be a native query.
