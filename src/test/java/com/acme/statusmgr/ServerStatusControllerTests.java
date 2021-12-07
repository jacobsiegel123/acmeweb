/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.statusmgr;

import com.acme.Details.Facade;
import com.acme.Details.MockFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class ServerStatusControllerTests {

    @Autowired
    private MockMvc mockMvc;
    String availableProcessors = ", and there are 4 processors available",
            freeJVMMemory = ", and there are 127268272 bytes of JVM memory free",
            totalJVMMemory = ", and there is a total of 159383552 bytes of JVM memory",
            jreVersion = ", and the JRE version is 15.0.2+7-27",
            tempLocation = ", and the server's temp file location is C:\\Users\\siege\\AppData\\Local\\Temp";

   @BeforeAll
    private static void setUp(){
       MockFacade mock = new MockFacade();
        Facade facade = new Facade();
        facade.setFacade(mock);
    }
    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/server/status")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.statusDesc").value("Server is up"));
    }

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/server/status").param("name", "RebYid"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by RebYid"));
    }

    @Test
    public void detailed_name_availProc() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" + availableProcessors));
    }

    @Test
    public void allSupportedDetails() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/server/status/detailed?name=Yankel&details=availableProcessors,freeJVMMemory,totalJVMMemory,jreVersion,tempLocation"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" +
                        availableProcessors +
                        freeJVMMemory + totalJVMMemory + jreVersion + tempLocation));
    }

    @Test
    public void repeatDetails() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/server/status/detailed?name=Yankel&details=availableProcessors,availableProcessors"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" + availableProcessors + availableProcessors));

    }

    @Test
    public void invalidDetailPassed() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/server/status/detailed?name=Yankel&details=availableProcessors,junkERROR"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(status().reason(is("Invalid details option: junkERROR")));
    }

    @Test
    public void missingDetails() throws Exception {

        this.mockMvc.perform(get("/server/status/detailed"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void totalJVMMemoryAndFreeJVMMemory() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=totalJVMMemory,freeJVMMemory"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.statusDesc").value("Server is up" + totalJVMMemory + freeJVMMemory));
    }

    @Test
    public void tempLocationJreVersionAndTotalJVMMemory() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=tempLocation,jreVersion,totalJVMMemory"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.statusDesc").value("Server is up" + tempLocation + jreVersion + totalJVMMemory));
    }

    @Test
    public void nameLastAndAvailableProcessorsAndJreVersionBeforeIt() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors,jreVersion&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" + availableProcessors + jreVersion));
    }

    @Test
    public void nameLastAndTotalJVMMemoryAndFreeJVMMemoryAndTempLocationBeforeIt() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=totalJVMMemory,freeJVMMemory,tempLocation&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" + totalJVMMemory + freeJVMMemory + tempLocation));
    }


    @Test
    public void nameFirstThenAndTotalJVMMemoryAndFreeJVMMemoryAndTempLocation() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?name=Yankel&details=totalJVMMemory,freeJVMMemory,tempLocation"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" + totalJVMMemory + freeJVMMemory + tempLocation));
    }
}
