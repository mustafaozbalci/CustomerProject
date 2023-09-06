package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.entities.Log;

import java.util.List;


public interface LogService {
    void saveLog(String logText);

    List<Log> getAllLogs();

}
