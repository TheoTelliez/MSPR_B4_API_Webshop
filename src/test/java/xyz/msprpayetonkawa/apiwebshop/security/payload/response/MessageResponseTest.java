package xyz.msprpayetonkawa.apiwebshop.security.payload.response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.msprpayetonkawa.apiwebshop.security.payload.response.MessageResponse;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MessageResponseTest {

    private MessageResponse messageResponse;

    @Before
    public void setUp() {
        messageResponse = new MessageResponse("Test Message");
    }

    @Test
    public void testGetAndSetMessage() {
        String newMessage = "New Test Message";
        messageResponse.setMessage(newMessage);
        assertEquals(newMessage, messageResponse.getMessage());
    }
}
