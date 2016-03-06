package commands

import it.uliana.hazelcastshell.HazelcastService
import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext
import org.crsh.command.ScriptException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.BeanFactory

class hazelcast {

    enum Commands {
        LIST,
        CLEAR,
        GET
    }

    private log = LoggerFactory.getLogger(hazelcast.class)

    @Usage("hazelcast <command>")
    @Command
    def main(InvocationContext context,
             @Required @Argument(name = "command") String command,
             @Argument(name = "name") String name) {
        BeanFactory beanFactory = context.attributes["spring.beanfactory"]
        HazelcastService hazelcastService = beanFactory.getBean(HazelcastService.class);

        if (command.equalsIgnoreCase(Commands.LIST.name())) {
            return hazelcastService.getMapNames()
        } else if (command.equalsIgnoreCase(Commands.CLEAR.name())) {
            return hazelcastService.clearAll()
        } else if (command.equalsIgnoreCase(Commands.GET.name())) {
            return hazelcastService.getMap(name)
        } else {
            throw new ScriptException("valid commands are: " +
                    Commands.values().join(", ")
            )
        }
    }
}
