package it.uliana.hazelcastshell;

import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.map.impl.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HazelcastService {

    private Logger log = LoggerFactory.getLogger(HazelcastService.class);

    @Autowired
    private HazelcastInstance hazelcastInstance;

    public IMap getMap(String name) {
        IMap map = hazelcastInstance.getMap(name);
        log.info(map.getName());
        return map;
    }

    public List<String> getMapNames() {

        return hazelcastInstance
                .getDistributedObjects()
                .stream()
                .filter(e -> e.getServiceName().equals(MapService.SERVICE_NAME))
                .map(DistributedObject::getName)
                .collect(Collectors.toList());
    }

    public void clearAll() {
        getMapNames()
                .forEach(name -> getMap(name).clear());
    }

}
