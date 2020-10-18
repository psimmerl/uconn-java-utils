package uconn.utils.pid.stefan;

public class HadronCuts {

    /**
     * DC fiducial cut for hadrons
     * @param dc_sector sector of hits in DC
     * @param region specify fiducial cuts for which region to use
     * @param trajx x for region 1 or 2 or 3 from REC::Traj
     * @param trajy y for region 1 or 2 or 3 from REC::Traj
     * @param trajz z for region 1 or 2 or 3 from REC::Traj
     * @param partpid pid assigned to particle candidate
     * @param isinbending True if magnetic field is inbending
     */
    public static boolean DC_fiducial_cut_theta_phi(int dc_sector, int region, double trajx, double trajy, double trajz, int partpid, boolean isinbending) {

// new cut parameters for the polynomial cut based on the local theta and phi coordinates (inbending field):
// replace it in the function: bool DC_fiducial_cut_theta_phi(int j, int region)
// (optimized for pi+ and pi-, not optimized for Kaons yet)
//

        double[][][][] maxparams_in = {
            {   {{-37.5489,27.4543,-1.11484,0.00522935},{-29.7228,26.7512,-1.52592,0.0122397},{-20.3559,23.1586,-1.47441,0.0133898}},
                {{-36.2719,25.1427,-0.817973,0.00233912},{-28.2118,25.0664,-1.29748,0.00947493},{-20.6015,22.9639,-1.39759,0.012069}},
                {{-34.1013,25.9343,-1.23555,0.00959955},{-24.0285,22.9346,-1.165,0.00846331},{-8.04969,12.5436,-0.268326,9.03561e-11}},
                {{-48.5546,36.1076,-2.07362,0.0161268},{-24.7284,22.9355,-1.12754,0.00796403},{-22.5292,24.1624,-1.52361,0.0137042}},
                {{-40.4295,30.8386,-1.77195,0.0156563},{-26.7149,23.5322,-1.1011,0.00715825},{-10.9822,13.8127,-0.312534,1.32292e-05}},
                {{-38.1396,28.0524,-1.19166,0.00613986},{-26.1238,24.3235,-1.28254,0.00950751},{-19.0376,22.042,-1.32482,0.0113948}}
            },
            {   {{-1.67037e-08,12.8334,-0.820443,0.00818882},{-6.23823,14.8659,-0.776403,0.00624484},{-5.75713,11.4787,-0.227124,6.61281e-10}},
                {{-6.09637e-07,12.7972,-0.813133,0.00808401},{-5.51055,13.9682,-0.639287,0.00441366},{-7.90046,12.5383,-0.271117,1.86929e-10}},
                {{-2.84217e-14,13.0836,-0.864047,0.00869759},{-6.78639,15.3367,-0.827197,0.00677168},{-4.8928,11.1884,-0.221965,1.51263e-10}},
                {{-3.8595e-09,12.9673,-0.841224,0.0083938},{-4.01784,12.9989,-0.557548,0.00367493},{-1.95023,9.69687,-0.157901,5.33239e-09}},
                {{-6.43496e-10,12.9804,-0.850651,0.00863353},{-5.10299,13.9958,-0.671087,0.00489619},{-6.03313,11.7973,-0.249435,1.2754e-11}},
                {{-2.94932e-10,13.1054,-0.859032,0.00848181},{-6.05945,14.7331,-0.742818,0.00558374},{-5.63811,11.6686,-0.247509,2.33147e-13}}
            },
            {   {{-2.68279e-07,12.99,-0.846226,0.00845788},{-14.6317,19.3874,-1.09244,0.00899541},{-38.1915,29.8688,-1.59229,0.0120089}},
                {{-0.996514,13.9379,-0.964686,0.00982941},{-15.9613,20.2461,-1.16106,0.00955431},{-35.9455,29.0996,-1.586,0.0122175}},
                {{-1.14284e-07,13.6015,-0.966952,0.0101523},{-15.5288,20.3045,-1.20523,0.0102808},{-34.2682,26.4216,-1.20609,0.0078434}},
                {{-1.70075e-08,13.0005,-0.832325,0.00817159},{-7.66776,15.4526,-0.779727,0.00585967},{-26.8035,23.9995,-1.2322,0.00942061}},
                {{-9.53804e-10,13.2563,-0.898206,0.00917629},{-6.85083,14.8485,-0.722803,0.0053221},{-39.3606,31.5412,-1.83015,0.0148302}},
                {{-7.66835e-07,13.937,-1.05153,0.0118223},{-9.7913,16.925,-0.913158,0.00712552},{-27.722,23.9412,-1.1314,0.00761088}}
            },
            {   {{-22.1832,20.4134,-0.764848,0.00310923},{-31.0844,28.2369,-1.715,0.0145145},{-9.52175,18.7932,-1.38896,0.0150233}},
                {{-21.5849,20.2457,-0.762109,0.00305359},{-19.5601,21.5945,-1.18955,0.00939109},{-1.57084,13.3989,-0.823161,0.00795227}},
                {{-16.052,16.6264,-0.444308,2.82701e-06},{-13.8291,18.6541,-1.01549,0.00825776},{-1.92223e-05,13.0305,-0.881089,0.00925281}},
                {{-19.821,18.4301,-0.516168,2.17199e-10},{-30.6295,28.0989,-1.71897,0.0146585},{-9.23709,17.1589,-1.03955,0.00943673}},
                {{-16.1795,16.7121,-0.448883,1.53774e-11},{-23.6418,24.5748,-1.48652,0.01254},{-4.2626e-09,12.899,-0.845374,0.00872171}},
                {{-9.74791,15.0287,-0.531727,0.00192371},{-41.0848,33.1802,-1.97671,0.0158148},{-4.12428,14.3361,-0.820483,0.00725632}}
            },
            {   {{-1.05499e-08,12.7347,-0.800158,0.00789171},{-3.78358,13.3272,-0.620589,0.0043452},{-31.0947,26.2276,-1.33783,0.00961276}},
                {{-3.20108e-05,13.2084,-0.89232,0.00907651},{-11.5913,18.4403,-1.08132,0.00895511},{-26.4998,23.4434,-1.09015,0.00695521}},
                {{-1.54979e-07,13.3849,-0.912541,0.00919697},{-4.77271,14.366,-0.750675,0.00582608},{-31.7881,27.2978,-1.49603,0.0115217}},
                {{-8.46957e-07,13.135,-0.863007,0.00850261},{-5.91254,14.7345,-0.748863,0.00564354},{-27.2818,24.4544,-1.24541,0.009006}},
                {{-8.97242e-09,12.8923,-0.825914,0.00815967},{-6.91507,16.0014,-0.917916,0.00756705},{-18.1359,18.5543,-0.695074,0.00311518}},
                {{-2.50141e-08,13.1356,-0.864227,0.00854005},{-6.62648,15.5703,-0.861224,0.00697927},{-19.9356,18.969,-0.647219,0.00209364}}
            },
            {   {{-31.056,26.1595,-1.20596,0.00643836},{-44.4944,36.2986,-2.35276,0.020162},{-12.2855,21.0109,-1.61628,0.0172125}},
                {{-27.3898,25.1282,-1.2366,0.00728902},{-24.9794,23.2357,-1.09342,0.00656412},{-16.9519,23.8236,-1.78734,0.017541}},
                {{-28.7906,26.9219,-1.49542,0.0104976},{-22.0922,23.6046,-1.37835,0.0110503},{-5.24383,16.5267,-1.15701,0.0113067}},
                {{-3.92728,12.0692,-0.372323,0.0011559},{-23.5702,22.3459,-1.04378,0.00649998},{-17.3561,24.4119,-1.93535,0.0204532}},
                {{-30.442,26.0012,-1.2191,0.00674908},{-54.5014,42.354,-2.8256,0.0242569},{-0.751452,13.9234,-0.958253,0.00952713}},
                {{-31.216,26.1169,-1.20087,0.00650951},{-31.0314,28.4075,-1.70479,0.0137299},{-13.8981,22.326,-1.72999,0.0176742}}
            }
        };


        double[][][][] minparams_in = {
            {   {{45.6964,-33.9555,1.83632,-0.0133721},{16.3132,-19.1709,0.95922,-0.00719164},{17.4745,-21.3091,1.29658,-0.0114378}},
                {{34.063,-25.5129,0.992129,-0.00445872},{22.4188,-23.1898,1.33328,-0.011079},{15.558,-20.779,1.32969,-0.0122892}},
                {{28.8399,-21.4732,0.662977,-0.00227941},{15.2776,-18.4944,0.917128,-0.00703012},{25.9277,-26.2555,1.70407,-0.0154587}},
                {{43.4091,-32.329,1.78095,-0.0143066},{34.8052,-27.7186,1.43403,-0.0108989},{26.384,-24.813,1.4364,-0.0123938}},
                {{42.094,-32.8674,2.12321,-0.0208007},{39.6248,-33.4591,2.1938,-0.0196953},{17.5854,-17.6921,0.617536,-0.00282672}},
                {{24.4957,-19.3118,0.481099,-6.0729e-07},{22.7714,-23.2117,1.31478,-0.0107808},{16.2955,-21.0448,1.33876,-0.0123879}}
            },
            {   {{2.01913e-05,-13.2206,0.868885,-0.00845047},{6.86331,-15.0105,0.765473,-0.00602765},{5.15884,-11.18,0.21433,-1.79763e-09}},
                {{3.24593,-15.5188,1.12128,-0.011555},{8.61633,-16.3281,0.913374,-0.00783236},{4.51456,-11.0507,0.243113,-0.000607925}},
                {{0.905676,-13.3623,0.85485,-0.00835569},{6.87062,-14.5731,0.694399,-0.00526577},{3.8283,-10.4277,0.178245,-4.2334e-10}},
                {{5.54817e-07,-12.6609,0.744683,-0.00664861},{6.25817,-14.6969,0.728253,-0.00543273},{6.01169,-11.8105,0.251251,-3.71394e-10}},
                {{9.30801e-09,-13.3207,0.888792,-0.00873133},{8.41797,-16.4985,0.956897,-0.00841779},{4.36256,-10.8341,0.202655,-3.44186e-09}},
                {{0.27863,-13.1208,0.833431,-0.0079631},{7.38412,-15.4188,0.82054,-0.00681735},{4.48567,-10.7376,0.190611,-9.77392e-10}}
            },
            {   {{1.59369e-06,-13.8294,0.990918,-0.0103128},{20.1273,-23.853,1.58449,-0.0145959},{40.8152,-32.8944,2.00731,-0.0171007}},
                {{1.4334,-14.5452,1.04379,-0.0106791},{19.9242,-23.3894,1.5036,-0.0134429},{45.1348,-34.9897,2.11238,-0.0175613}},
                {{4.48276e-06,-12.6688,0.757818,-0.006981},{10.2525,-16.9056,0.909637,-0.00739798},{33.2958,-27.7763,1.53467,-0.0123488}},
                {{3.817e-06,-13.2285,0.856439,-0.0081744},{12.5356,-19.0801,1.1686,-0.0102758},{37.3388,-29.7344,1.64296,-0.0130658}},
                {{3.64842e-07,-14.1631,1.0771,-0.0118569},{9.85442,-17.8198,1.12641,-0.010627},{34.7,-28.5335,1.57226,-0.0124004}},
                {{0.828721,-13.6429,0.895665,-0.00866683},{10.8176,-18.0919,1.11147,-0.010183},{29.9288,-24.3389,1.08973,-0.00703934}}
            },
            {   {{15.8302,-16.9632,0.53561,-0.00136216},{32.8002,-29.2569,1.79783,-0.015324},{1.98393,-13.0099,0.70788,-0.00615153}},
                {{16.0367,-16.5901,0.470678,-0.000728065},{32.4005,-29.7403,1.92286,-0.0171968},{2.39707,-13.6612,0.816883,-0.00770837}},
                {{22.0623,-21.6319,1.02811,-0.00680893},{32.7467,-29.6099,1.87839,-0.0164223},{1.19902e-08,-12.972,0.863127,-0.00884759}},
                {{21.5883,-21.198,0.957819,-0.00575361},{25.7387,-25.4963,1.5428,-0.0131855},{6.06479,-16.6311,1.16092,-0.0117194}},
                {{19.6915,-19.1751,0.704086,-0.00288768},{28.6596,-27.3351,1.70309,-0.0148193},{5.30096e-08,-11.8562,0.621373,-0.00541869}},
                {{20.6594,-19.8704,0.786033,-0.00394155},{20.7612,-22.3774,1.27116,-0.0104109},{2.56196,-14.4159,0.98009,-0.0100214}}
            },
            {   {{6.84429e-08,-11.7778,0.558372,-0.00403519},{5.88119,-14.1561,0.630592,-0.00400605},{22.9399,-21.6066,0.97379,-0.00604844}},
                {{5.49686,-16.3382,1.10037,-0.0105049},{9.25791,-16.8955,0.947447,-0.00774283},{19.4826,-18.4694,0.587601,-0.00147216}},
                {{0.148482,-12.4191,0.691879,-0.00595948},{6.95863,-15.5624,0.862069,-0.00725014},{16.6631,-16.746,0.461105,-0.000520762}},
                {{2.64705e-10,-11.8828,0.574528,-0.00419463},{5.45746,-13.9134,0.602948,-0.00360009},{31.3252,-27.342,1.51348,-0.0115756}},
                {{3.46769,-15.3338,1.02031,-0.00951104},{0.368693,-11.8657,0.574108,-0.0044343},{39.7957,-32.8529,2.02652,-0.016978}},
                {{0.00207118,-12.0447,0.602167,-0.00447581},{3.03476,-12.9176,0.603586,-0.00440659},{32.0315,-26.8451,1.37417,-0.00966969}}
            },
            {   {{56.9355,-42.3826,2.61014,-0.0202986},{28.8989,-27.1772,1.63996,-0.0136625},{4.30155,-15.1455,0.995784,-0.0100192}},
                {{13.4916,-17.1287,0.681434,-0.0031646},{32.246,-29.0499,1.77696,-0.0148718},{2.22052,-9.65178,0.133616,-9.0964e-05}},
                {{41.8686,-33.5132,1.92542,-0.0142307},{0.0645903,-9.74163,0.217245,-2.22987e-05},{9.58895e-09,-13.2013,0.926579,-0.00993616}},
                {{34.8087,-28.1804,1.3547,-0.00784213},{31.3059,-28.7057,1.76134,-0.0146575},{8.66833,-17.8896,1.20937,-0.0116248}},
                {{42.0802,-33.525,1.91492,-0.0140721},{36.8805,-31.3893,1.91131,-0.0157056},{6.11008,-17.0626,1.24276,-0.0127673}},
                {{39.6762,-31.6354,1.73354,-0.0123964},{30.2451,-27.8243,1.67413,-0.0138583},{4.78902,-14.9558,0.912758,-0.00855026}}
            }
        };


        //fitted values outbending
        double[][][][] maxparams_out = {
            {   {{-3.69457, 12.3755, -0.41328, 0.00129631},{-54.3237, 40.3308, -2.39952, 0.0181339},{-39.8661, 27.1428, -0.907303, 0.00220974}},
                {{-37.6199, 26.2865, -0.826366, 0.000862203},{-72.4212, 54.7953, -4.04856, 0.0373308},{-21.1791, 17.0759, -0.391795, 0.00151085}},
                {{-0.421685, 10.482, -0.272111, 8.69408e-05},{-43.3635, 32.746, -1.6541, 0.0101454},{-62.6387, 41.1869, -1.97298, 0.0107022}},
                {{-42.0766, 29.6387, -0.993426, 1.97101e-09},{-44.7036, 33.0587, -1.64131, 0.0099416},{-47.2703, 32.6109, -1.46533, 0.00817871}},
                {{-22.2035, 20.6894, -0.689051, 0.000592423},{-74.6572, 54.7065, -3.83999, 0.0351952},{-38.9183, 25.7212, -0.711499, 2.5796e-12}},
                {{-52.078, 45.571, -3.71942, 0.0376577},{-65.4047, 49.1723, -3.36623, 0.0288435},{-53.9611, 35.9294, -1.58589, 0.00772417}}
            },
            {   {{-2.20312e-07, 13.0916, -0.864184, 0.0086342},{-6.44026e-08, 12.056, -0.675801, 0.00643464},{-20.2596, 23.5977, -1.545, 0.0141047}},
                {{-4.42537e-05, 10.2799, -0.322454, 0.00154825},{-1.63659e-07, 11.0228, -0.451412, 0.00308633},{-8.5382, 15.6903, -0.785315, 0.00602734}},
                {{-2.32088, 11.6343, -0.363509, 0.000902217},{-0.301128, 12.0319, -0.643794, 0.00581994},{-22.4378, 25.2772, -1.73656, 0.0164181}},
                {{-7.40627, 13.601, -0.382439, 2.45262e-05},{-5.50415e-08, 11.9792, -0.652368, 0.00597647},{-15.1608, 20.6455, -1.33827, 0.0127123}},
                {{-0.203913, 10.7032, -0.322123, 0.000691162},{-1.73184e-07, 10.735, -0.379993, 0.00196037},{-0.155443, 10.1794, -0.249841, 6.24278e-05}},
                {{-1.87352e-07, 12.4226, -0.730141, 0.0068049},{-1.40236e-07, 12.5356, -0.750615, 0.00719921},{-16.8681, 21.8555, -1.43078, 0.0131935}}
            },
            {   {{-8.89326e-08, 10.0681, -0.240869, 9.9612e-12},{-15.2705, 21.635, -1.55291, 0.0166645},{-10.5976, 17.9928, -1.08432, 0.00950807}},
                {{-0.00389562, 10.2092, -0.254082, 4.15737e-06},{-9.16032e-11, 10.527, -0.334641, 0.00129061},{-9.63013e-07, 11.0668, -0.42453, 0.0022955}},
                {{-2.40163e-06, 13.4151, -0.949883, 0.0107662},{-1.60937e-07, 10.5128, -0.35046, 0.00173787},{-29.2647, 30.1252, -2.20552, 0.0213809}},
                {{-2.69733e-08, 11.7703, -0.589854, 0.00482124},{-3.77564e-08, 11.3764, -0.527037, 0.00416671},{-4.85047, 13.7737, -0.650441, 0.0047428}},
                {{-3.90816e-07, 12.2683, -0.692591, 0.00625884},{-9.70203e-10, 11.0335, -0.438323, 0.00275342},{-2.54193, 13.5404, -0.76861, 0.00684486}},
                {{-3.23439e-10, 10.7412, -0.348557, 0.00113794},{-1.79623, 11.7499, -0.449432, 0.00247294},{-13.1393, 19.4689, -1.17148, 0.00984086}}
            },
            {   {{-5.07611e-08, 11.7796, -0.516966, 0.00295389},{-4.87018, 12.2727, -0.322719, 9.12315e-06},{-35.9369, 31.015, -1.95133, 0.0169834}},
                {{-1.32385e-07, 11.6454, -0.495467, 0.00272602},{-2.70664, 12.0151, -0.434014, 0.00203292},{-8.97137, 15.0453, -0.646138, 0.00429196}},
                {{-7.92247e-09, 12.5189, -0.682231, 0.00539531},{-0.0942499, 10.3465, -0.280521, 0.000405358},{-19.7485, 21.7919, -1.24334, 0.0105088}},
                {{-8.50093e-11, 10.739, -0.302295, 5.6862e-11},{-0.184771, 10.4358, -0.285869, 0.000389546},{-21.9469, 24.9675, -1.77893, 0.0183075}},
                {{-4.34589, 12.5902, -0.362849, 4.996e-15},{-0.000684493, 10.6055, -0.332363, 0.00104632},{-21.328, 22.0864, -1.20993, 0.00989151}},
                {{-0.0202168, 12.0097, -0.539165, 0.00299034},{-0.5239, 10.7167, -0.309141, 0.000535617},{-10.0299, 16.3179, -0.812315, 0.00617078}}
            },
            {   {{-0.169908, 10.902, -0.353938, 0.00100715},{-3.2818, 13.2193, -0.65495, 0.00515117},{-0.013532, 8.51331, -0.070239, 1.755e-05}},
                {{-8.51985e-08, 11.6512, -0.56808, 0.00453582},{-1.2381e-07, 10.6653, -0.368149, 0.00181989},{-9.30287e-08, 10.0352, -0.254321, 0.000417053}},
                {{-0.150407, 10.6338, -0.308676, 0.000481694},{-0.00186321, 10.4259, -0.303092, 0.00073092},{-21.3328, 28.0803, -2.37912, 0.025101}},
                {{-14.4411, 19.817, -1.13705, 0.00894685},{-6.25263e-09, 11.7414, -0.586098, 0.00478932},{-5.49193, 16.1248, -1.11306, 0.0115644}},
                {{-1.54761, 12.0015, -0.462506, 0.00204729},{-5.72883, 14.9638, -0.795325, 0.00616222},{-50.229, 45.8456, -3.88803, 0.0414729}},
                {{-40.7531, 33.6269, -2.03771, 0.01609},{-1.33363e-09, 11.9894, -0.614358, 0.004924},{-27.2506, 29.2602, -2.1426, 0.0203235}}
            },
            {   {{-1.62999e-10, 14.0422, -1.03609, 0.0107179},{-6.71565, 15.6964, -0.887791, 0.00740777},{-38.9148, 32.9935, -2.09023, 0.0177295}},
                {{-1.09078e-05, 13.4131, -0.878092, 0.00825152},{-15.0102, 21.6968, -1.4935, 0.0138851},{-19.5261, 20.3932, -0.969464, 0.00661531}},
                {{-1.39619e-08, 12.3593, -0.618488, 0.00415536},{-5.38271e-07, 11.5631, -0.512607, 0.00334452},{-23.0902, 24.7093, -1.57315, 0.0140132}},
                {{-1.73908e-08, 12.0348, -0.591608, 0.00423834},{-8.35134, 17.3066, -1.11555, 0.010407},{-2.74909e-07, 9.59202, -0.216455, 0.000527479}},
                {{-0.0449157, 10.5243, -0.334389, 0.00134555},{-0.0143489, 10.0993, -0.2434, 1.57595e-10},{-22.3661, 23.2499, -1.32946, 0.0108047}},
                {{-5.83731e-07, 14.5234, -1.14022, 0.0122177},{-1.4586e-08, 11.6946, -0.520935, 0.00324975},{-12.4252, 16.3216, -0.652566, 0.00365791}}
            }
        };

        double[][][][] minparams_out = {
            {   {{3.73672, -12.3584,0.390616, -0.000795415},{51.644, -37.8546,1.99228, -0.0119973},{32.3551, -22.9742,0.624096, -4.30811e-05}},
                {{6.11614, -13.6358,0.491668, -0.0018637},{47.5098, -35.902,1.97535, -0.0134876},{82.9536, -58.2741,4.12662, -0.0378612}},
                {{0.000950108, -7.99619,0.000506416, -0.0020788},{64.0688, -47.8642,3.16007, -0.025878},{70.0064, -50.3249,3.38975, -0.029639}},
                {{37.0145, -35.0316,2.61892, -0.0250306},{14.5954, -15.6554,0.426733, -0.000879865},{28.9035, -21.5279,0.610475, -0.00087271}},
                {{5.65685, -13.3347,0.400781, -1.46612e-11},{67.3504, -50.152,3.33677, -0.0270726},{47.0772, -32.1506,1.38851, -0.00719898}},
                {{8.95987, -15.1646,0.585477, -0.00246174},{41.6154, -29.7967,1.1817, -0.00403765},{61.1631, -41.6465,2.32522, -0.0175271}}
            },
            {   {{8.80954e-10, -11.0364,0.413853, -0.00210254},{6.50072e-08, -11.2505,0.501571, -0.00380973},{10.9643, -17.4701,0.989297, -0.00860789}},
                {{2.33292e-08, -11.2353,0.470728, -0.00309666},{2.29373e-07, -11.2458,0.50218, -0.00383969},{29.5429, -29.9965,2.19166, -0.021366}},
                {{1.61826e-08, -11.861,0.577321, -0.00433276},{2.9436e-07, -11.5738,0.581015, -0.00503307},{19.5142, -23.451,1.58724, -0.0151339}},
                {{2.07231e-09, -12.7453,0.751184, -0.00664181},{1.77802e-07, -11.4574,0.537367, -0.00422656},{12.5683, -18.4632,1.05475, -0.00892182}},
                {{7.6216e-08, -13.9769,1.01051, -0.0107372},{1.33092e-08, -11.9128,0.628521, -0.00550105},{13.5537, -20.1708,1.32578, -0.0123213}},
                {{9.25941, -19.658,1.51566, -0.0157124},{6.25983e-10, -11.6806,0.599263, -0.00532588},{17.0479, -22.0046,1.47474, -0.0140475}}
            },
            {   {{4.65436e-08, -11.1925,0.466196, -0.00308992},{18.4968, -22.5122,1.4594, -0.0135962},{18.9488, -23.3348,1.57414, -0.0146183}},
                {{3.67722e-08, -10.9985,0.428395, -0.00257574},{16.3745, -21.0105,1.3093, -0.0119156},{11.4404, -18.6679,1.15919, -0.010306}},
                {{1.46846e-08, -10.865,0.398638, -0.00212392},{20.7337, -23.3738,1.46852, -0.0130115},{28.2098, -28.9406,2.05908, -0.0197782}},
                {{0.237058, -10.4694,0.271985, -1.08731e-07},{2.32759, -11.9354,0.469887, -0.00291497},{13.287, -20.8621,1.49656, -0.0148999}},
                {{0.000149907, -10.4632,0.294713, -0.000431947},{6.96663, -15.3946,0.845078, -0.00724722},{11.0939, -17.4733,0.944239, -0.00747728}},
                {{3.10006e-08, -10.1416,0.247764, -1.36913e-11},{5.41915, -14.6085,0.795369, -0.00684375},{5.89127, -13.0881,0.453024, -0.0020325}}
            },
            {   {{4.16588e-09, -12.9305,0.749425, -0.00611725},{5.65263, -14.1661,0.637395, -0.00400239},{4.66325, -12.9519,0.565753, -0.00442033}},
                {{8.0428e-08, -13.1625,0.836744, -0.00778246},{12.3243, -18.8718,1.11103, -0.00917354},{7.20312, -16.0935,0.987223, -0.00930883}},
                {{0.00147165, -10.4992,0.280542, -1.79846e-06},{3.20232, -11.6892,0.350774, -0.00101099},{8.14117e-08, -10.9813,0.524839, -0.00507885}},
                {{0.470888, -13.5446,0.820782, -0.00768941},{3.9697, -13.0821,0.540847, -0.00303209},{3.44817, -12.3932,0.533804, -0.00414144}},
                {{1.05038e-08, -10.6539,0.297078, -6.04694e-05},{15.0983, -21.1791,1.38383, -0.0124058},{17.3666, -20.3986,1.16663, -0.0102393}},
                {{8.49365e-07, -13.765,0.964056, -0.00956575},{9.38084, -16.7385,0.904339, -0.00707907},{12.1048, -17.3704,0.91318, -0.00757461}}
            },
            {   {{10.6378, -19.5017,1.45275, -0.017057},{1.24368e-08, -10.5134,0.338985, -0.00143696},{37.3291, -35.1606,2.60092, -0.0242728}},
                {{19.1614, -24.0851,1.73932, -0.0185466},{14.1293, -19.8382,1.21613, -0.0107037},{20.9629, -24.0839,1.60283, -0.015173}},
                {{0.000450804, -8.15062,0.0103867, -2.00709e-05},{5.72496, -14.338,0.717819, -0.00567964},{16.9428, -21.8075,1.4216, -0.0131736}},
                {{6.15991e-10, -11.5278,0.536105, -0.00402223},{2.17842e-07, -10.5338,0.327427, -0.0010898},{20.7387, -24.3028,1.65004, -0.0155857}},
                {{0.650351, -10.6177,0.275393, -6.4664e-08},{8.05811, -16.1558,0.913735, -0.00788487},{0.308897, -10.2816,0.275186, -0.000561299}},
                {{0.427836, -10.168,0.240458, -5.90042e-06},{2.30661, -12.8686,0.664796, -0.00562626},{0.00499667, -11.6585,0.62597, -0.00619261}}
            },
            {   {{9.01249e-07, -11.8437,0.494125, -0.00223452},{14.3941, -21.2365,1.46048, -0.0137349},{13.7095, -15.4704,0.408961, -0.000312145}},
                {{0.000251044, -11.3084,0.438545, -0.0020791},{0.00847078, -12.6769,0.804431, -0.00836705},{1.09388, -9.66797,0.175278, -1.8721e-11}},
                {{4.04693e-10, -11.9001,0.585913, -0.00440376},{5.05178, -12.1514,0.31134, -0.000112735},{30.8105, -28.0795,1.73625, -0.0151639}},
                {{3.86607e-11, -13.471,0.889111, -0.0083617},{8.86591e-09, -9.25745,0.163052, -6.08491e-12},{27.1358, -24.3255,1.23326, -0.00891886}},
                {{0.196086, -11.7392,0.480055, -0.00224614},{0.18667, -10.5859,0.287231, -6.53153e-06},{14.8865, -17.1338,0.653576, -0.00333176}},
                {{2.7955e-07, -13.1311,0.848222, -0.00812719},{29.5508, -32.9514,2.77917, -0.0291596},{59.7514, -47.3033,3.54495, -0.0341802}}
            }
        };

        double[][][][] minparams = isinbending ? minparams_in : minparams_out;
        double[][][][] maxparams = isinbending ? maxparams_in : maxparams_out;


        double trajr = Math.sqrt(Math.pow(trajx,2) + Math.pow(trajy,2) + Math.pow(trajz,2));
        double theta_DCr = Math.toDegrees(Math.acos(trajz/trajr));
        double phi_DCr_raw = Math.toDegrees(Math.atan2(trajy/trajr, trajx/trajr));

        double phi_DCr = 5000;

        if (dc_sector == 1) phi_DCr = phi_DCr_raw;
        if (dc_sector == 2) phi_DCr = phi_DCr_raw - 60;
        if (dc_sector == 3) phi_DCr = phi_DCr_raw - 120;
        if (dc_sector == 4 && phi_DCr_raw > 0) phi_DCr = phi_DCr_raw - 180;
        if (dc_sector == 4 && phi_DCr_raw < 0) phi_DCr = phi_DCr_raw + 180;
        if (dc_sector == 5) phi_DCr = phi_DCr_raw + 120;
        if (dc_sector == 6) phi_DCr = phi_DCr_raw + 60;

        int pid = 0;

        switch (partpid)
        {
        case 11:
            pid = 0;
            break;
        case 2212:
            pid = 1;
            break;
        case 211:
            pid = 2;
            break;
        case -211:
            pid = 3;
            break;
        case 321:
            pid = 4;
            break;
        case -321:
            pid = 5;
            break;
        default:
            return false;
        }

        double calc_phi_min = minparams[pid][dc_sector-1][region-1][0] + minparams[pid][dc_sector-1][region-1][1] * Math.log(theta_DCr) + minparams[pid][dc_sector-1][region-1][2] * theta_DCr + minparams[pid][dc_sector-1][region-1][3] * theta_DCr * theta_DCr;

        double calc_phi_max = maxparams[pid][dc_sector-1][region-1][0] + maxparams[pid][dc_sector-1][region-1][1] * Math.log(theta_DCr) + maxparams[pid][dc_sector-1][region-1][2] * theta_DCr + maxparams[pid][dc_sector-1][region-1][3] * theta_DCr * theta_DCr;

        return (phi_DCr > calc_phi_min) && (phi_DCr < calc_phi_max);
    }



    /** Delta VZ cut for hadrons
     * @param pid hadron PID code
     * @param dvz difference between Vz of hadron candidate and electron
    */
    public static boolean Delta_vz_cut(int pid, double dvz) {
        switch(pid) {
        case 2212:
            return dvz>-20 && dvz<20;
        case 22:
            return dvz>-20 && dvz<20;
        case 2112:
            return dvz>-20 && dvz<20;
        case 211:
            return dvz>-20 && dvz<20;
        case -211:
            return dvz>-20 && dvz<20;
        case 321:
            return dvz>-20 && dvz<20;
        case -321:
            return dvz>-20 && dvz<20;
        }
        return false;
    }



    /** chi2pid cut for hadrons
     * @param chi2pid chi2pid value
     * @param pid hadron PID code
    */
    public static boolean Chi2pid_cut(double chi2pid, double p, int pid) {
        boolean isstrict = false;

        double coef;
        if(pid==211) coef = 0.88;
        else if(pid==-211) coef = 0.93;
        else return false;

        boolean chi2cut = false;
        if(isstrict) {
            if(p<2.44) chi2cut = chi2pid < 3*coef;
            else if(p<4.6) chi2cut = chi2pid < coef*(0.00869 + 14.98587*Math.exp(-p/1.18236) + 1.81751*Math.exp(-p/4.86394));
            else chi2cut = chi2pid<coef*(-1.14099 + 24.14992*Math.exp(-p/1.36554) + 2.66876*Math.exp(-p/6.80522));
        } else {
            if(p<2.44) chi2cut = chi2pid < 3*coef;
            else chi2cut = chi2pid < coef*(0.00869 + 14.98587*Math.exp(-p/1.18236) + 1.81751*Math.exp(-p/4.86394));
        }

        return chi2cut && chi2pid>coef*-3;
    }

}
