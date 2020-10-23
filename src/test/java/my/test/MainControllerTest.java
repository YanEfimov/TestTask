package my.test;

import my.task.AppRun;
import my.task.controller.MainController;
import my.task.dto.ResponseCard;
import my.task.dto.ResponseClient;
import my.task.service.MainService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = AppRun.class)
@AutoConfigureMockMvc
@DirtiesContext
@RunWith(SpringRunner.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private MainController controller;

    @MockBean
    private MainService mainService;

    @Before
    public void setUp() {
        when(mainService.createCard(anyObject()))
                .thenReturn(ResponseEntity.ok(new ResponseClient(1L)));
        when(mainService.createCard(anyObject()))
                .thenReturn(ResponseEntity.ok(new ResponseCard(1L)));
    }


    @Test
    public void createClient_OK() throws Exception {
        mockMvc.perform(post("/api/client")
                .header("authorization", "Basic YWRtaW46YWJjMTIz")
                .header("Content-Type","application/json")
                .content("{\n" +
                        "\t\"fullName\":\"Yan Efimov\",\n" +
                        "\t\"telephone\":\"3752934343\",\n" +
                        "\t\"email\":\"yan.efimov@gmail.com\"\n" +
                        "\n" +
                        "}"))
                .andExpect(status().is(200));
    }

    @Test
    public void createClient_Unauthorized() throws Exception {
        mockMvc.perform(post("/api/client")
                .header("authorization", "Basic YWRtaW46YWJjMTIz1")
                .header("Content-Type","application/json")
                .content("{\n" +
                        "\t\"fullName\":\"Yan Efimov\",\n" +
                        "\t\"telephone\":\"3752934343\",\n" +
                        "\t\"email\":\"yan.efimov@gmail.com\"\n" +
                        "\n" +
                        "}"))
                .andExpect(status().is(401));
    }


}
