package entity;

public class Admin {

    private AdminFile adminFile = null;
    private String projectPath = null;

    public AdminFile getAdminFile() {
        return adminFile;
    }

    public void setAdminFile(AdminFile adminFile) {
        this.adminFile = adminFile;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }
}
