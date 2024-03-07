package app;

public class Persona {
    private String personaID;
    private String personaName;
    private String imgPath;
    private String description;
    private String needs;
    private String goals;
    private String skillsExp;


    public Persona(String personaID, String personaName, String imgPath, String description, String needs, String goals, String skillsExp) {
        this.personaID = personaID;
        this.personaName = personaName;
        this.imgPath = imgPath;
        this.description = description;
        this.needs = needs;
        this.goals = goals;
        this.skillsExp = skillsExp;
    }

    public String getPersonaId() {
        return personaID;
    }

    public String getPersonaName() {
        return personaName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getDescription() {
        return description;
    }

    public String getNeeds() {
        return needs;
    }

    public String getGoals() {
        return goals;
    }

    public String getSkillsExp() {
        return skillsExp;
    }
}
