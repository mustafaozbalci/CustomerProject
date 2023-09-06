package Customer.FirstProject.service;

import Customer.FirstProject.dataAccess.LogRepository;
import Customer.FirstProject.entities.Log;
import Customer.FirstProject.serviceAbstracts.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LogServiceImp implements LogService {

    private final LogRepository logRepository;

    public void saveLog(String logText) {
        Log log = new Log();
        log.setLog(logText);
        log.setLogDate(LocalDate.now());
        logRepository.save(log);
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

}
