package dto;

import java.util.Map;

public class Route {
    private String routeName;
    private String weatherConditions;
    private String alert;
    private Map<String, String> conditions;

    public Route(String routeName, String weatherConditions, String alert, Map<String, String> conditions) {
        this.routeName = routeName;
        this.weatherConditions = weatherConditions;
        this.alert = alert;
        this.conditions = conditions;
    }
}
