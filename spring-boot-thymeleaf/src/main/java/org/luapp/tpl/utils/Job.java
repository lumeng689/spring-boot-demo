package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private String title;
    private List<String> responsibilities = new ArrayList<>();
    private List<String> requirements = new ArrayList<>();

    public Job() {

    }

    public Job(String title, List<String> responsibilities, List<String> requirements) {
        this.title = title;
        this.responsibilities = responsibilities;
        this.requirements = requirements;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }
}
