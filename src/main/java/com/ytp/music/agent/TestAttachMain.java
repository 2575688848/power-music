package com.ytp.music.agent;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

/**
 * @author pinge
 */
public class TestAttachMain {

    public static void main(String[] args) throws Exception {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor descriptor : list) {
            System.out.println("VirtualMachineDescriptor Name : " + descriptor.displayName());
            if (descriptor.displayName().endsWith("AgentTargetSample")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(descriptor.id());
                virtualMachine.loadAgent("/Users/ytp/ideaProjects/java-agent/target/javaAgent-1.0.jar", "arg1");
                virtualMachine.detach();
            }
        }
    }
}
