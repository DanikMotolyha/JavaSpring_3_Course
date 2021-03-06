package by.motolyha.scooter;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void go() throws Exception {
        mockMvc.perform(post("/scooter/all")).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void go1() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}