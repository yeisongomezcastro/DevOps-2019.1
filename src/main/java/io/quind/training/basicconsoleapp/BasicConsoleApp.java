package io.quind.training.basicconsoleapp;

import io.quind.training.basicconsoleapp.adapters.persistence.FileHandler;
import io.quind.training.basicconsoleapp.adapters.userinterface.MembershipManagement;
import io.quind.training.basicconsoleapp.domain.Member;

import java.util.LinkedList;

public class BasicConsoleApp {
    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = fh.readMembersFile();
        int choice = mm.getChoice();

        while (choice != -1) {
            switch (choice) {
                case 1:
                    mem = mm.addMembers(members);
                    System.out.println("Member Added: \n" + mem + "\n");
                    fh.appendFile(members.getLast());
                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("You've selected an invalid option");
            }
            choice = mm.getChoice();
        }
        System.out.println("Bye!");
    }
}