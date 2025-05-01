package com.nrt.tms.util;

public class MappingConstant {

    public static class Project {
        public static final String BASE = "/api/tms/project";
        public static final String CREATE = "/create";
        public static final String FIND_ALL = "/find-all";
        public static final String UPDATE = "/{projectCode}/update";
        public static final String DELETE = "/{projectCode}/delete";
    }

    public static class Team {
        public static final String BASE = "/api/tms/team";
        public static final String CREATE = "/create";
        public static final String FETCH_TEAM_WITH_MEMBERS = "/{teamId}/fetch-team-member";
        public static final String FETCH_ALL_TEAMS = "/fetch-all-team";
    }


}

