package com.acme.statusmgr;

import com.acme.statusmgr.beans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();

    /**
     * Process a request for server status information
     *
     * @param name optional param identifying the requestor
     * @return a ServerStatus object containing the info to be returned to the requestor
     */
    @RequestMapping("/status")
    public ServerStatus serverStatusHandler(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                            @RequestParam(value = "details", required = false) List<String> details) {
        Logger logger = LoggerFactory.getLogger("StuffImInterestedIn");
        logger.info("details "+ details);
        if(details == null){
            return new ServerStatus(counter.incrementAndGet(),
                    String.format(template, name));
        }
        else{
            return new ServerStatus(counter.incrementAndGet(),
                    String.format(template, name) + " the list is "+ details);
        }

    }

    @RequestMapping("/status/detailed")
    public ServerStatusInterface getDetailedServerStatus(@RequestParam(value="name", defaultValue="Anonymous") String name,
                                                         @RequestParam(value="details", required = false) List<String> details) {
        //System.out.println("what details got passed in" + details);
        ServerStatusInterface status = new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));
        if(details != null) {
            for (String s : details) {
                //for each detail decorate the appropriate class
                if (s.equals("availableProcessors")) {
                    status = new AvailableProcessorDecorator(status);
                }
                else if (s.equals("freeJVMMemory")) {
                    status = new FreeJVMMemoryDecorator(status);
                }
                else if (s.equals("totalJVMMemory")) {
                    status = new TotalJVMMemoryDecorator(status);
                }
                else if (s.equals("jreVersion")) {
                    status = new JreVersionDecorator(status);
                }
                else if (s.equals("tempLocation")) {
                    status = new TempLocationDecorator(status);
                }
                else {
                    throw new DetailInvalidEx();
                }

            }

            }
        else {
            throw new MissingListException();
        }
        return status;
    }

}
