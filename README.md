# singlestoneDemo
Take home exercise for SingleStone Back End Java

# Testing
I am a big advocate for testing. But in this case, I don't think there's much to test with Unit Tests. There's plenty to test wih Integration tests, and with @DataJpaTest making repository testing much easier than it used to be, I would normally have tests for that.

# Call-list
In the real world, and with performance in mind, this would probably be better to do the sorting at the query level, instead of processing the whole collection again at the service layer. But with the sort on the different table, I didn't know how to do that with the JPA query methods. Maybe it just needed to be a native query.
