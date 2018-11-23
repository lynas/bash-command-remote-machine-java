package com.lynas;

import com.pastdev.jsch.DefaultSessionFactory;
import com.pastdev.jsch.command.CommandRunner;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        DefaultSessionFactory sessionFactory = new DefaultSessionFactory(
                "lynas", "192.168.106.128", 22
        );
        Map props = new HashMap<String, String>();
        props.put("StrictHostKeyChecking", "no");
        sessionFactory.setConfig(props);
        sessionFactory.setPassword("87");

        CommandRunner runner = new CommandRunner(sessionFactory);

        String command = "ls -al";
        CommandRunner.ExecuteResult result = runner.execute(command);

        if (result.getStderr().isEmpty()) {
            System.out.println(result.getStdout());
        } else {
            System.out.println(result.getStderr());
        }

        runner.close();
    }
}
