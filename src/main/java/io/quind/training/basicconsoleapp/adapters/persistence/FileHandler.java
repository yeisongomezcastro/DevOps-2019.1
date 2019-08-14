package io.quind.training.basicconsoleapp.adapters.persistence;

import io.quind.training.basicconsoleapp.domain.Member;
import io.quind.training.basicconsoleapp.domain.MultiClubMember;
import io.quind.training.basicconsoleapp.domain.SingleClubMember;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {
    public LinkedList<Member> readMembersFile() {
        LinkedList<Member> memberList = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member member;

        try (BufferedReader reader = new BufferedReader(new FileReader("member.csv"))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(", ");
                if (splitLine[0].equals("S")) {
                    member = new SingleClubMember(Integer.parseInt(splitLine[1]), 'S', splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                } else {
                    member = new MultiClubMember(Integer.parseInt(splitLine[1]), 'M', splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                }
                memberList.add(member);
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return memberList;
    }

    public void appendFile(Member member) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("member.csv", true))) {
            writer.write(member + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void overwriteFile(LinkedList<Member> memberList) {
        String memberString;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
            for (Member member : memberList) {
                memberString = member.toString();
                writer.write(memberString + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            File f = new File("members.csv");
            File tf = new File("members.temp");
            System.out.println(f.delete() ? "File deleted" : "Error during file deletion");
            System.out.println(tf.renameTo(f) ? "File renamed" : "Error during file rename");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
