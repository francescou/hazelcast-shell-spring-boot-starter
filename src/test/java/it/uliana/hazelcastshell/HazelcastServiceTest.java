package it.uliana.hazelcastshell;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by francesco on 07/04/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class HazelcastServiceTest {

    private Logger log = LoggerFactory.getLogger(HazelcastServiceTest.class);

    @Autowired
    private HazelcastService hazelcastService;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    private static final String FOO = "foo";
    private static final String BAR = "bar";
    private static final String BAZ = "baz";

    @Before
    public void setUp() {
        IMap<String, String> map = hazelcastInstance.getMap(FOO);
        map.put(BAR, BAZ);
    }


    @Test
    public void testGetMap() throws Exception {
        IMap<String, String> m = hazelcastService.getMap(FOO);
        assertEquals(BAZ, m.get(BAR));
    }

    @Test
    public void testGetMapNames() throws Exception {
        assertTrue(hazelcastService.getMapNames().contains(FOO));
    }

    @Test
    public void testClearAll() throws Exception {
        hazelcastService.clearAll();
        assertTrue(hazelcastService.getMap(FOO).isEmpty());
    }
}