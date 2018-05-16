package org.luapp.tpl.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JobUtils {

    public static List<Job> readJobs(File file) throws IOException {
        List<Job> jobs = Lists.newArrayList();
        List<String> lines = FileUtils.readLines(file, "UTF-8");

        boolean startJob = true;
        boolean startRes = false;
        boolean startReq = false;

        // 0 初始状态 1 读取完job名称  2 读取职责  3 读取要求
        int step = 0;

        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                if (step != 0) {
                    step = (step + 1) % 4;
                }
                continue;
            }

            if (step == 0) {
                Job job = new Job();
                job.setTitle(line);
                jobs.add(job);
                step = 1;
                continue;
            }

            char c = line.charAt(0);

            if (c < 0 || c > '9') {
                if (step == 1) {
                    step = 2;
                } else if (step == 2) {
                    step = 3;
                }
                continue;
            }

            if (step == 2) {
                jobs.get(jobs.size() - 1).getResponsibilities().add(line);
                continue;
            }

            if (step == 3) {
                jobs.get(jobs.size() - 1).getRequirements().add(line);
            }
        }

        return jobs;
    }

    public static JSONObject parse(Job job) {
        String category = "H1xllXK7e";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("_id", "Hyfta8wrCZ");
        jsonObject.put("title", job.getTitle());
        jsonObject.put("stitle", job.getTitle());
        jsonObject.put("tags", "Careers");
        jsonObject.put("category", category);
        jsonObject.put("sortPath", "0,HyOOcPS7g," + category);
        jsonObject.put("comments", "");
        jsonObject.put("author", "rJST4SSme");
        jsonObject.put("from", "1");
        jsonObject.put("likeNum", 0);
        jsonObject.put("commentNum", 0);
        jsonObject.put("clickNum", 336);
        jsonObject.put("isTop", 0);
        jsonObject.put("state", true);
        jsonObject.put("updateDate", new Date());
        jsonObject.put("date", new Date());
        jsonObject.put("sImg", "/upload/smallimgs/img20170116115459.jpg");
        jsonObject.put("type", "content");

        String p = "<p><span style=\"font-size: 20px;\"><strong>工作地点：</strong></span><br/></p><p><span style=\"font-size: 18px;\">";
        p += "深圳";
        p += "</span></p><p><br/> &nbsp; &nbsp;<br/></p><p><span style=\"font-size: 20px;\"><strong>岗位职责：</strong></span><br/></p><p><span style=\"font-size: 20px;\"><strong><br/></strong></span></p><ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\">";

        for (String s : job.getResponsibilities()) {
            p += "<li><p><span style=\"font-size: 18px;\">" + s + " </span></p></li>";
        }
        p += "</ul><p><br/> &nbsp; &nbsp;<br/></p><p><span style=\"font-size: 20px;\"><strong>任职要求：</strong></span><br/></p><p><span style=\"font-size: 20px;\"><strong><br/></strong></span></p><ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\">";

        for (String t : job.getRequirements()) {
            p += "<li><p><span style=\"font-size: 18px;\">" + t + "</span></p></li>";
        }
        p += "</ul><p><br/></p><p><br/></p><p><strong style=\"font-size: 20px; white-space: normal;\"></strong></p><p><strong><span style=\"font-size: 18px;\">简历投递：dream@cloudminds.com</span></strong></p><p><strong><span style=\"font-size: 18px;\">投递邮件主题格式：投递职位+姓名+学校</span></strong></p><p><br/></p>";

        jsonObject.put("comments", p);
        return jsonObject;
    }

    public static void main(String[] args) throws Exception {
        List<Job> jobs = readJobs(new File("D:\\tmp\\job\\sz.txt"));

        JSONArray jsonArray = new JSONArray();

        for (Job job : jobs) {
            jsonArray.add(parse(job));
        }

        System.out.println(jsonArray.toJSONString());

//        System.out.println("[0-9]+".matches("aa"));
    }
}
