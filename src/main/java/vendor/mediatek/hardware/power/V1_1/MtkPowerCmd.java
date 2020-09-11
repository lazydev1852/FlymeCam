package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkPowerCmd {
    public static final int CMD_SET_BG_BOOST_VALUE = 37;
    public static final int CMD_SET_CLUSTER_CPU_CORE_MAX = 2;
    public static final int CMD_SET_CLUSTER_CPU_CORE_MIN = 1;
    public static final int CMD_SET_CLUSTER_CPU_FREQ_MAX = 4;
    public static final int CMD_SET_CLUSTER_CPU_FREQ_MIN = 3;
    public static final int CMD_SET_CPUFREQ_ABOVE_HISPEED_DELAY = 14;
    public static final int CMD_SET_CPUFREQ_HISPEED_FREQ = 12;
    public static final int CMD_SET_CPUFREQ_MIN_SAMPLE_TIME = 13;
    public static final int CMD_SET_CPU_PERF_MODE = 5;
    public static final int CMD_SET_DCM_MODE = 52;
    public static final int CMD_SET_DCS_MODE = 53;
    public static final int CMD_SET_DFPS = 40;
    public static final int CMD_SET_DISP_DECOUPLE = 68;
    public static final int CMD_SET_DVFS_POWER_MODE = 15;
    public static final int CMD_SET_EXT_LAUNCH_MON = 63;
    public static final int CMD_SET_FBT_FLOOR_BOUND = 59;
    public static final int CMD_SET_FBT_KMIN = 60;
    public static final int CMD_SET_FG_BOOST_VALUE = 36;
    public static final int CMD_SET_FPSGO_ENABLE = 55;
    public static final int CMD_SET_FSTB_FORCE_VAG = 56;
    public static final int CMD_SET_FSTB_FPS = 54;
    public static final int CMD_SET_GED_BENCHMARK_ON = 57;
    public static final int CMD_SET_GLOBAL_CPUSET = 33;
    public static final int CMD_SET_GPU_FREQ_MAX = 7;
    public static final int CMD_SET_GPU_FREQ_MIN = 6;
    public static final int CMD_SET_GX_BOOST = 58;
    public static final int CMD_SET_HPS_DOWN_THRESHOLD = 17;
    public static final int CMD_SET_HPS_DOWN_TIMES = 19;
    public static final int CMD_SET_HPS_HEAVY_TASK = 21;
    public static final int CMD_SET_HPS_POWER_MODE = 22;
    public static final int CMD_SET_HPS_RBOOST_THRESH = 49;
    public static final int CMD_SET_HPS_RUSH_BOOST = 20;
    public static final int CMD_SET_HPS_UP_THRESHOLD = 16;
    public static final int CMD_SET_HPS_UP_TIMES = 18;
    public static final int CMD_SET_IDLE_PREFER = 31;
    public static final int CMD_SET_IO_BOOST_VALUE = 69;
    public static final int CMD_SET_MTK_PREFER_IDLE = 65;
    public static final int CMD_SET_OPP_DDR = 62;
    public static final int CMD_SET_PACK_BOOST_MODE = 38;
    public static final int CMD_SET_PACK_BOOST_TIMEOUT = 39;
    public static final int CMD_SET_PPM_HICA_VAR = 26;
    public static final int CMD_SET_PPM_HOLD_TIME_LL_ONLY = 48;
    public static final int CMD_SET_PPM_HOLD_TIME_L_ONLY = 42;
    public static final int CMD_SET_PPM_LIMIT_BIG = 46;
    public static final int CMD_SET_PPM_MODE = 25;
    public static final int CMD_SET_PPM_NORMALIZED_PERF_INDEX = 24;
    public static final int CMD_SET_PPM_ROOT_CLUSTER = 23;
    public static final int CMD_SET_PPM_SPORTS_MODE = 47;
    public static final int CMD_SET_ROOT_BOOST_VALUE = 34;
    public static final int CMD_SET_SCHED_AVG_HTASK_AC = 28;
    public static final int CMD_SET_SCHED_AVG_HTASK_THRESH = 29;
    public static final int CMD_SET_SCHED_HTASK_THRESH = 27;
    public static final int CMD_SET_SCHED_LB_ENABLE = 32;
    public static final int CMD_SET_SCHED_MODE = 30;
    public static final int CMD_SET_SCREEN_OFF_STATE = 11;
    public static final int CMD_SET_SMART_FORCE_ISOLATE = 50;
    public static final int CMD_SET_SPCOND_RESV_I = 71;
    public static final int CMD_SET_SPCOND_RESV_II = 72;
    public static final int CMD_SET_SPCOND_RESV_III = 73;
    public static final int CMD_SET_SPCOND_RESV_IV = 74;
    public static final int CMD_SET_SPCOND_RESV_IX = 79;
    public static final int CMD_SET_SPCOND_RESV_V = 75;
    public static final int CMD_SET_SPCOND_RESV_VI = 76;
    public static final int CMD_SET_SPCOND_RESV_VII = 77;
    public static final int CMD_SET_SPCOND_RESV_VIII = 78;
    public static final int CMD_SET_SPCOND_RESV_X = 80;
    public static final int CMD_SET_SPCOND_RESV_XI = 81;
    public static final int CMD_SET_SPCOND_RESV_XII = 82;
    public static final int CMD_SET_SPCOND_RESV_XIII = 83;
    public static final int CMD_SET_SPCOND_RESV_XIV = 84;
    public static final int CMD_SET_SPCOND_RESV_XIX = 89;
    public static final int CMD_SET_SPCOND_RESV_XV = 85;
    public static final int CMD_SET_SPCOND_RESV_XVI = 86;
    public static final int CMD_SET_SPCOND_RESV_XVII = 87;
    public static final int CMD_SET_SPCOND_RESV_XVIII = 88;
    public static final int CMD_SET_SPCOND_RESV_XX = 90;
    public static final int CMD_SET_SPORTS_MODE = 41;
    public static final int CMD_SET_STUNE_FG_PERFER_IDLE = 67;
    public static final int CMD_SET_STUNE_TA_PERFER_IDLE = 66;
    public static final int CMD_SET_STUNE_THRESH = 51;
    public static final int CMD_SET_TA_BOOST_VALUE = 35;
    public static final int CMD_SET_VCORE = 45;
    public static final int CMD_SET_VCORE_BW_ENABLED = 9;
    public static final int CMD_SET_VCORE_BW_THRES = 8;
    public static final int CMD_SET_VCORE_BW_THRES_DDR3 = 43;
    public static final int CMD_SET_VCORE_MIN = 10;
    public static final int CMD_SET_VCORE_MIN_DDR3 = 44;
    public static final int CMD_SET_VIDEO_MODE = 61;
    public static final int CMD_SET_WALT_FOLLOW = 64;
    public static final int CMD_SET_WIPHY_CAM = 70;

    public static final String toString(int i) {
        if (i == 1) {
            return "CMD_SET_CLUSTER_CPU_CORE_MIN";
        }
        if (i == 2) {
            return "CMD_SET_CLUSTER_CPU_CORE_MAX";
        }
        if (i == 3) {
            return "CMD_SET_CLUSTER_CPU_FREQ_MIN";
        }
        if (i == 4) {
            return "CMD_SET_CLUSTER_CPU_FREQ_MAX";
        }
        if (i == 5) {
            return "CMD_SET_CPU_PERF_MODE";
        }
        if (i == 6) {
            return "CMD_SET_GPU_FREQ_MIN";
        }
        if (i == 7) {
            return "CMD_SET_GPU_FREQ_MAX";
        }
        if (i == 8) {
            return "CMD_SET_VCORE_BW_THRES";
        }
        if (i == 9) {
            return "CMD_SET_VCORE_BW_ENABLED";
        }
        if (i == 10) {
            return "CMD_SET_VCORE_MIN";
        }
        if (i == 11) {
            return "CMD_SET_SCREEN_OFF_STATE";
        }
        if (i == 12) {
            return "CMD_SET_CPUFREQ_HISPEED_FREQ";
        }
        if (i == 13) {
            return "CMD_SET_CPUFREQ_MIN_SAMPLE_TIME";
        }
        if (i == 14) {
            return "CMD_SET_CPUFREQ_ABOVE_HISPEED_DELAY";
        }
        if (i == 15) {
            return "CMD_SET_DVFS_POWER_MODE";
        }
        if (i == 16) {
            return "CMD_SET_HPS_UP_THRESHOLD";
        }
        if (i == 17) {
            return "CMD_SET_HPS_DOWN_THRESHOLD";
        }
        if (i == 18) {
            return "CMD_SET_HPS_UP_TIMES";
        }
        if (i == 19) {
            return "CMD_SET_HPS_DOWN_TIMES";
        }
        if (i == 20) {
            return "CMD_SET_HPS_RUSH_BOOST";
        }
        if (i == 21) {
            return "CMD_SET_HPS_HEAVY_TASK";
        }
        if (i == 22) {
            return "CMD_SET_HPS_POWER_MODE";
        }
        if (i == 23) {
            return "CMD_SET_PPM_ROOT_CLUSTER";
        }
        if (i == 24) {
            return "CMD_SET_PPM_NORMALIZED_PERF_INDEX";
        }
        if (i == 25) {
            return "CMD_SET_PPM_MODE";
        }
        if (i == 26) {
            return "CMD_SET_PPM_HICA_VAR";
        }
        if (i == 27) {
            return "CMD_SET_SCHED_HTASK_THRESH";
        }
        if (i == 28) {
            return "CMD_SET_SCHED_AVG_HTASK_AC";
        }
        if (i == 29) {
            return "CMD_SET_SCHED_AVG_HTASK_THRESH";
        }
        if (i == 30) {
            return "CMD_SET_SCHED_MODE";
        }
        if (i == 31) {
            return "CMD_SET_IDLE_PREFER";
        }
        if (i == 32) {
            return "CMD_SET_SCHED_LB_ENABLE";
        }
        if (i == 33) {
            return "CMD_SET_GLOBAL_CPUSET";
        }
        if (i == 34) {
            return "CMD_SET_ROOT_BOOST_VALUE";
        }
        if (i == 35) {
            return "CMD_SET_TA_BOOST_VALUE";
        }
        if (i == 36) {
            return "CMD_SET_FG_BOOST_VALUE";
        }
        if (i == 37) {
            return "CMD_SET_BG_BOOST_VALUE";
        }
        if (i == 38) {
            return "CMD_SET_PACK_BOOST_MODE";
        }
        if (i == 39) {
            return "CMD_SET_PACK_BOOST_TIMEOUT";
        }
        if (i == 40) {
            return "CMD_SET_DFPS";
        }
        if (i == 41) {
            return "CMD_SET_SPORTS_MODE";
        }
        if (i == 42) {
            return "CMD_SET_PPM_HOLD_TIME_L_ONLY";
        }
        if (i == 43) {
            return "CMD_SET_VCORE_BW_THRES_DDR3";
        }
        if (i == 44) {
            return "CMD_SET_VCORE_MIN_DDR3";
        }
        if (i == 45) {
            return "CMD_SET_VCORE";
        }
        if (i == 46) {
            return "CMD_SET_PPM_LIMIT_BIG";
        }
        if (i == 47) {
            return "CMD_SET_PPM_SPORTS_MODE";
        }
        if (i == 48) {
            return "CMD_SET_PPM_HOLD_TIME_LL_ONLY";
        }
        if (i == 49) {
            return "CMD_SET_HPS_RBOOST_THRESH";
        }
        if (i == 50) {
            return "CMD_SET_SMART_FORCE_ISOLATE";
        }
        if (i == 51) {
            return "CMD_SET_STUNE_THRESH";
        }
        if (i == 52) {
            return "CMD_SET_DCM_MODE";
        }
        if (i == 53) {
            return "CMD_SET_DCS_MODE";
        }
        if (i == 54) {
            return "CMD_SET_FSTB_FPS";
        }
        if (i == 55) {
            return "CMD_SET_FPSGO_ENABLE";
        }
        if (i == 56) {
            return "CMD_SET_FSTB_FORCE_VAG";
        }
        if (i == 57) {
            return "CMD_SET_GED_BENCHMARK_ON";
        }
        if (i == 58) {
            return "CMD_SET_GX_BOOST";
        }
        if (i == 59) {
            return "CMD_SET_FBT_FLOOR_BOUND";
        }
        if (i == 60) {
            return "CMD_SET_FBT_KMIN";
        }
        if (i == 61) {
            return "CMD_SET_VIDEO_MODE";
        }
        if (i == 62) {
            return "CMD_SET_OPP_DDR";
        }
        if (i == 63) {
            return "CMD_SET_EXT_LAUNCH_MON";
        }
        if (i == 64) {
            return "CMD_SET_WALT_FOLLOW";
        }
        if (i == 65) {
            return "CMD_SET_MTK_PREFER_IDLE";
        }
        if (i == 66) {
            return "CMD_SET_STUNE_TA_PERFER_IDLE";
        }
        if (i == 67) {
            return "CMD_SET_STUNE_FG_PERFER_IDLE";
        }
        if (i == 68) {
            return "CMD_SET_DISP_DECOUPLE";
        }
        if (i == 69) {
            return "CMD_SET_IO_BOOST_VALUE";
        }
        if (i == 70) {
            return "CMD_SET_WIPHY_CAM";
        }
        if (i == 71) {
            return "CMD_SET_SPCOND_RESV_I";
        }
        if (i == 72) {
            return "CMD_SET_SPCOND_RESV_II";
        }
        if (i == 73) {
            return "CMD_SET_SPCOND_RESV_III";
        }
        if (i == 74) {
            return "CMD_SET_SPCOND_RESV_IV";
        }
        if (i == 75) {
            return "CMD_SET_SPCOND_RESV_V";
        }
        if (i == 76) {
            return "CMD_SET_SPCOND_RESV_VI";
        }
        if (i == 77) {
            return "CMD_SET_SPCOND_RESV_VII";
        }
        if (i == 78) {
            return "CMD_SET_SPCOND_RESV_VIII";
        }
        if (i == 79) {
            return "CMD_SET_SPCOND_RESV_IX";
        }
        if (i == 80) {
            return "CMD_SET_SPCOND_RESV_X";
        }
        if (i == 81) {
            return "CMD_SET_SPCOND_RESV_XI";
        }
        if (i == 82) {
            return "CMD_SET_SPCOND_RESV_XII";
        }
        if (i == 83) {
            return "CMD_SET_SPCOND_RESV_XIII";
        }
        if (i == 84) {
            return "CMD_SET_SPCOND_RESV_XIV";
        }
        if (i == 85) {
            return "CMD_SET_SPCOND_RESV_XV";
        }
        if (i == 86) {
            return "CMD_SET_SPCOND_RESV_XVI";
        }
        if (i == 87) {
            return "CMD_SET_SPCOND_RESV_XVII";
        }
        if (i == 88) {
            return "CMD_SET_SPCOND_RESV_XVIII";
        }
        if (i == 89) {
            return "CMD_SET_SPCOND_RESV_XIX";
        }
        if (i == 90) {
            return "CMD_SET_SPCOND_RESV_XX";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        boolean z = 1;
        if ((i & 1) == 1) {
            arrayList.add("CMD_SET_CLUSTER_CPU_CORE_MIN");
        } else {
            z = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CMD_SET_CLUSTER_CPU_CORE_MAX");
            z |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("CMD_SET_CLUSTER_CPU_FREQ_MIN");
            z |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("CMD_SET_CLUSTER_CPU_FREQ_MAX");
            z |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("CMD_SET_CPU_PERF_MODE");
            z |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("CMD_SET_GPU_FREQ_MIN");
            z |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("CMD_SET_GPU_FREQ_MAX");
            z |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("CMD_SET_VCORE_BW_THRES");
            z |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("CMD_SET_VCORE_BW_ENABLED");
            z |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("CMD_SET_VCORE_MIN");
            z |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("CMD_SET_SCREEN_OFF_STATE");
            z |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("CMD_SET_CPUFREQ_HISPEED_FREQ");
            z |= true;
        }
        if ((i & 13) == 13) {
            arrayList.add("CMD_SET_CPUFREQ_MIN_SAMPLE_TIME");
            z |= true;
        }
        if ((i & 14) == 14) {
            arrayList.add("CMD_SET_CPUFREQ_ABOVE_HISPEED_DELAY");
            z |= true;
        }
        if ((i & 15) == 15) {
            arrayList.add("CMD_SET_DVFS_POWER_MODE");
            z |= true;
        }
        if ((i & 16) == 16) {
            arrayList.add("CMD_SET_HPS_UP_THRESHOLD");
            z |= true;
        }
        if ((i & 17) == 17) {
            arrayList.add("CMD_SET_HPS_DOWN_THRESHOLD");
            z |= true;
        }
        if ((i & 18) == 18) {
            arrayList.add("CMD_SET_HPS_UP_TIMES");
            z |= true;
        }
        if ((i & 19) == 19) {
            arrayList.add("CMD_SET_HPS_DOWN_TIMES");
            z |= true;
        }
        if ((i & 20) == 20) {
            arrayList.add("CMD_SET_HPS_RUSH_BOOST");
            z |= true;
        }
        if ((i & 21) == 21) {
            arrayList.add("CMD_SET_HPS_HEAVY_TASK");
            z |= true;
        }
        if ((i & 22) == 22) {
            arrayList.add("CMD_SET_HPS_POWER_MODE");
            z |= true;
        }
        if ((i & 23) == 23) {
            arrayList.add("CMD_SET_PPM_ROOT_CLUSTER");
            z |= true;
        }
        if ((i & 24) == 24) {
            arrayList.add("CMD_SET_PPM_NORMALIZED_PERF_INDEX");
            z |= true;
        }
        if ((i & 25) == 25) {
            arrayList.add("CMD_SET_PPM_MODE");
            z |= true;
        }
        if ((i & 26) == 26) {
            arrayList.add("CMD_SET_PPM_HICA_VAR");
            z |= true;
        }
        if ((i & 27) == 27) {
            arrayList.add("CMD_SET_SCHED_HTASK_THRESH");
            z |= true;
        }
        if ((i & 28) == 28) {
            arrayList.add("CMD_SET_SCHED_AVG_HTASK_AC");
            z |= true;
        }
        if ((i & 29) == 29) {
            arrayList.add("CMD_SET_SCHED_AVG_HTASK_THRESH");
            z |= true;
        }
        if ((i & 30) == 30) {
            arrayList.add("CMD_SET_SCHED_MODE");
            z |= true;
        }
        if ((i & 31) == 31) {
            arrayList.add("CMD_SET_IDLE_PREFER");
            z |= true;
        }
        if ((i & 32) == 32) {
            arrayList.add("CMD_SET_SCHED_LB_ENABLE");
            z |= true;
        }
        if ((i & 33) == 33) {
            arrayList.add("CMD_SET_GLOBAL_CPUSET");
            z |= true;
        }
        if ((i & 34) == 34) {
            arrayList.add("CMD_SET_ROOT_BOOST_VALUE");
            z |= true;
        }
        if ((i & 35) == 35) {
            arrayList.add("CMD_SET_TA_BOOST_VALUE");
            z |= true;
        }
        if ((i & 36) == 36) {
            arrayList.add("CMD_SET_FG_BOOST_VALUE");
            z |= true;
        }
        if ((i & 37) == 37) {
            arrayList.add("CMD_SET_BG_BOOST_VALUE");
            z |= true;
        }
        if ((i & 38) == 38) {
            arrayList.add("CMD_SET_PACK_BOOST_MODE");
            z |= true;
        }
        if ((i & 39) == 39) {
            arrayList.add("CMD_SET_PACK_BOOST_TIMEOUT");
            z |= true;
        }
        if ((i & 40) == 40) {
            arrayList.add("CMD_SET_DFPS");
            z |= true;
        }
        if ((i & 41) == 41) {
            arrayList.add("CMD_SET_SPORTS_MODE");
            z |= true;
        }
        if ((i & 42) == 42) {
            arrayList.add("CMD_SET_PPM_HOLD_TIME_L_ONLY");
            z |= true;
        }
        if ((i & 43) == 43) {
            arrayList.add("CMD_SET_VCORE_BW_THRES_DDR3");
            z |= true;
        }
        if ((i & 44) == 44) {
            arrayList.add("CMD_SET_VCORE_MIN_DDR3");
            z |= true;
        }
        if ((i & 45) == 45) {
            arrayList.add("CMD_SET_VCORE");
            z |= true;
        }
        if ((i & 46) == 46) {
            arrayList.add("CMD_SET_PPM_LIMIT_BIG");
            z |= true;
        }
        if ((i & 47) == 47) {
            arrayList.add("CMD_SET_PPM_SPORTS_MODE");
            z |= true;
        }
        if ((i & 48) == 48) {
            arrayList.add("CMD_SET_PPM_HOLD_TIME_LL_ONLY");
            z |= true;
        }
        if ((i & 49) == 49) {
            arrayList.add("CMD_SET_HPS_RBOOST_THRESH");
            z |= true;
        }
        if ((i & 50) == 50) {
            arrayList.add("CMD_SET_SMART_FORCE_ISOLATE");
            z |= true;
        }
        if ((i & 51) == 51) {
            arrayList.add("CMD_SET_STUNE_THRESH");
            z |= true;
        }
        if ((i & 52) == 52) {
            arrayList.add("CMD_SET_DCM_MODE");
            z |= true;
        }
        if ((i & 53) == 53) {
            arrayList.add("CMD_SET_DCS_MODE");
            z |= true;
        }
        if ((i & 54) == 54) {
            arrayList.add("CMD_SET_FSTB_FPS");
            z |= true;
        }
        if ((i & 55) == 55) {
            arrayList.add("CMD_SET_FPSGO_ENABLE");
            z |= true;
        }
        if ((i & 56) == 56) {
            arrayList.add("CMD_SET_FSTB_FORCE_VAG");
            z |= true;
        }
        if ((i & 57) == 57) {
            arrayList.add("CMD_SET_GED_BENCHMARK_ON");
            z |= true;
        }
        if ((i & 58) == 58) {
            arrayList.add("CMD_SET_GX_BOOST");
            z |= true;
        }
        if ((i & 59) == 59) {
            arrayList.add("CMD_SET_FBT_FLOOR_BOUND");
            z |= true;
        }
        if ((i & 60) == 60) {
            arrayList.add("CMD_SET_FBT_KMIN");
            z |= true;
        }
        if ((i & 61) == 61) {
            arrayList.add("CMD_SET_VIDEO_MODE");
            z |= true;
        }
        if ((i & 62) == 62) {
            arrayList.add("CMD_SET_OPP_DDR");
            z |= true;
        }
        if ((i & 63) == 63) {
            arrayList.add("CMD_SET_EXT_LAUNCH_MON");
            z |= true;
        }
        if ((i & 64) == 64) {
            arrayList.add("CMD_SET_WALT_FOLLOW");
            z |= true;
        }
        if ((i & 65) == 65) {
            arrayList.add("CMD_SET_MTK_PREFER_IDLE");
            z |= true;
        }
        if ((i & 66) == 66) {
            arrayList.add("CMD_SET_STUNE_TA_PERFER_IDLE");
            z |= true;
        }
        if ((i & 67) == 67) {
            arrayList.add("CMD_SET_STUNE_FG_PERFER_IDLE");
            z |= true;
        }
        if ((i & 68) == 68) {
            arrayList.add("CMD_SET_DISP_DECOUPLE");
            z |= true;
        }
        if ((i & 69) == 69) {
            arrayList.add("CMD_SET_IO_BOOST_VALUE");
            z |= true;
        }
        if ((i & 70) == 70) {
            arrayList.add("CMD_SET_WIPHY_CAM");
            z |= true;
        }
        if ((i & 71) == 71) {
            arrayList.add("CMD_SET_SPCOND_RESV_I");
            z |= true;
        }
        if ((i & 72) == 72) {
            arrayList.add("CMD_SET_SPCOND_RESV_II");
            z |= true;
        }
        if ((i & 73) == 73) {
            arrayList.add("CMD_SET_SPCOND_RESV_III");
            z |= true;
        }
        if ((i & 74) == 74) {
            arrayList.add("CMD_SET_SPCOND_RESV_IV");
            z |= true;
        }
        if ((i & 75) == 75) {
            arrayList.add("CMD_SET_SPCOND_RESV_V");
            z |= true;
        }
        if ((i & 76) == 76) {
            arrayList.add("CMD_SET_SPCOND_RESV_VI");
            z |= true;
        }
        if ((i & 77) == 77) {
            arrayList.add("CMD_SET_SPCOND_RESV_VII");
            z |= true;
        }
        if ((i & 78) == 78) {
            arrayList.add("CMD_SET_SPCOND_RESV_VIII");
            z |= true;
        }
        if ((i & 79) == 79) {
            arrayList.add("CMD_SET_SPCOND_RESV_IX");
            z |= true;
        }
        if ((i & 80) == 80) {
            arrayList.add("CMD_SET_SPCOND_RESV_X");
            z |= true;
        }
        if ((i & 81) == 81) {
            arrayList.add("CMD_SET_SPCOND_RESV_XI");
            z |= true;
        }
        if ((i & 82) == 82) {
            arrayList.add("CMD_SET_SPCOND_RESV_XII");
            z |= true;
        }
        if ((i & 83) == 83) {
            arrayList.add("CMD_SET_SPCOND_RESV_XIII");
            z |= true;
        }
        if ((i & 84) == 84) {
            arrayList.add("CMD_SET_SPCOND_RESV_XIV");
            z |= true;
        }
        if ((i & 85) == 85) {
            arrayList.add("CMD_SET_SPCOND_RESV_XV");
            z |= true;
        }
        if ((i & 86) == 86) {
            arrayList.add("CMD_SET_SPCOND_RESV_XVI");
            z |= true;
        }
        if ((i & 87) == 87) {
            arrayList.add("CMD_SET_SPCOND_RESV_XVII");
            z |= true;
        }
        if ((i & 88) == 88) {
            arrayList.add("CMD_SET_SPCOND_RESV_XVIII");
            z |= true;
        }
        if ((i & 89) == 89) {
            arrayList.add("CMD_SET_SPCOND_RESV_XIX");
            z |= true;
        }
        if ((i & 90) == 90) {
            arrayList.add("CMD_SET_SPCOND_RESV_XX");
            z |= true;
        }
        if (i != z) {
            arrayList.add("0x" + Integer.toHexString(i & (~(z ? 1 : 0))));
        }
        return String.join(" | ", arrayList);
    }
}
