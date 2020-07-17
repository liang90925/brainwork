//public class OrgStructure {
//}
//
//
//import java.io.*;
//        import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
//
// # Given an org-chart denoted as a string in the following format:
//#
//# "id:name:manager_id,id:name:manager_id"
//#
//# Ex.
//# "1:Max:4,2:Ann:0,3:Albert:2,4:Edmond:2"
//#
//# Print out an orgchart in simple ascii
//#
//# For the example above print out the following:
//#
//# Ann
//# - Albert
//# - Edmond
//# -- Max
//#
// */
//
//class Solution {
//    public class Employee{
//        String name;
//        Integer id;
//        Integer level;
//        Integer mId;
//        Map<Integer, Employee> reports;
//
//        public Employee(Integer id) {
//            this.id = id;
//            this.level = 0;
//            this.reports = new HashMap<>();
//        }
//    }
//
//
//
//    public String getOrgStructure(String orgChart) {
//        Map<Integer, Employee> orgMap = new HashMap<>();
//
//
//        // Parse the orgchar to employee
//        String[] items = orgChart.split(",");
//
//        for(String item: items) {
//            String[] person = item.split(":");
//            int id = Integer.parseInt(person[0]);
//            String name = person[1];
//            int managerId = Integer.parseInt(person[2]);
//
//
//            if (!orgMap.containsKey(id)) {
//                Employee em = new Employee(id);
//                orgMap.put(id, em);
//            }
//            Employee report = orgMap.get(id);
//            report.name = name;
//            report.mId = managerId;
//            report.level++;
//
//            // Add the reports into to manager, if manager did not exist, creat one
//            if (!orgMap.containsKey(managerId)) {
//                Employee mem = new Employee(managerId);
//                orgMap.put(managerId, mem);
//            }
//            orgMap.get(managerId).reports.put(id, report);
//        }
//
//
//        return dfs(0, orgMap);
//
//    }
//
//    private String dfs(int id, Map<Integer, Employee> orgMap) {
//        Employee em = orgMap.get(id);
//
//        String org = "";
//        int i = 0;
//        while(i < em.level) {
//            org += "-";
//            i++;
//        }
//        org += " " + em.name + "/n";
//
//        if (em.reports.isEmpty()) {
//            return org;
//        }
//
//        for (Map.Entry<Integer,Employee> entry: em.reports.entrySet()) {
//            org += dfs(entry.getKey(), orgMap);
//            org += "/n";
//        }
//
//        return org;
//    }
//
//    public static void main(String[] args) {
//
//        Solution solution = new Solution();
//
//        System.out.println(solution.getOrgStructure("1:Max:2,2:Ann:0"));
//        System.out.println(solution.getOrgStructure("1:Max:4,2:Ann:0,3:Albert:2,4:Edmond:2"));
//
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java " + Runtime.version().feature());
//
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }
//}
