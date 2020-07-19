package router;

import activityaction.ActivityEnum;

/**
 * 定义
 */
public enum  ActivityRouterEnum {
    login(ActivityEnum.LoginActivity, new ActivityEnum[]{ActivityEnum.MainActivity})
    ;
    ActivityEnum activityEnum;

    private ActivityEnum[] parentList;


    ActivityRouterEnum(ActivityEnum activityEnum, ActivityEnum[] parentList) {
        this.activityEnum = activityEnum;
        this.parentList = parentList;
    }
}
