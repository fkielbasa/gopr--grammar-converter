package dto;

import java.util.Map;

public class Route {
    private String routeName;
    private String routeDifficulty;
    private String alert;
    private Map<String, String> conditions;

    public Route(String routeName, String routeDifficulty, String alert, Map<String, String> conditions) {
        this.routeName = routeName;
        this.routeDifficulty = routeDifficulty;
        this.alert = alert;
        this.conditions = conditions;
    }
}
