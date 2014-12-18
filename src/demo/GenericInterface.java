/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

/**
 *
 * @author project
 */
public interface GenericInterface {
    //list command//
    String start[]={"adb shell am start -n ","adb logcat ActivityManager:V "," *:S","adb shell su -c'cp "};
    String insgenbench="adb install -r C:\\application\\apps\\apk_benchmark\\";
    String installSiragonapp="adb install C:\\application\\apps\\siragonapp.apk";
    String startapps[]={"org.uguess.android.sysinfo/.SiragonInfo",
    "com.antutu.ABenchMark/com.antutu.ABenchMark.ABenchMarkStart","com.eembc.coremark/.tabs",
    "com.quicinc.vellamo/.main.MainActivity","com.glbenchmark.glbenchmark27/net.kishonti.gfxbench.GfxMainActivity",
    "com.futuremark.dmandroid.application/.activity.MainActivity","com.batterybench/.MainActivity",
    "com.primatelabs.geekbench/.HomeActivity","com.rightware.BasemarkOSII/.BasemarkOSII",
    "com.rightware.BasemarkX_Free/com.unity3d.player.UnityPlayerProxyActivity",
    "com.twitter.android/.StartActivity","com.instagram.android/.activity.MainTabActivity",
    "com.facebook.katana/.LoginActivity","com.whatsapp/.Main","com.skype.raider/.Main"};
    String pullfile="adb pull /sdcard/logs C:\\application\\deviceRegisters";
    String devicedisp="adb devices";
    String removeFadb="adb shell rm /storage/sdcard0/ADB/*";
    String down="adb shell input keyevent 20";
    String web="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
   + " file:///C:/Users/project/Documents/GitHub/test/src/demo/manual/index.html";

    String server="C:\\Users\\project\\Desktop\\a.bat";
    String folderegister="C:\\application\\deviceRegisters\\";
    String folderappbench="C:\\application\\apps\\apk_benchmark\\";
    String folderLogs="C:\\application\\logs\\";
    String folderimg="C:\\application\\img";
    String pullimg="adb pull /sdcard/app-siragon/captures/";
    String runlogcat="adb logcat *:W > /storage/sdcard0/ADB/";
    //list message
    String detect="Dispositivo detectado";
    String offline="Dispositivo desconectado";
    String company="Síragon";
    String emptyd="empty directory";
    String errorlogin="Username/Password es inválido";
    String valdev="Dispositivo";
    String valmod="Modelo";
    String valprod="Producto";
    String valmarc="Marca";
    String valrel="Release";
    String valbui="Build";
    String valoc="Locale";
    String valker="Kernel";
    String valextt="Almacenamiento externo SD total";
    String valextd="Almacenamiento externo SD Disponible";
    String vala2sdt="Almacenamiento A2SD total";
    String vala2sdd="Almacenamiento A2SD Disponible";
    String valph="Pantalla Height";
    String valpw="Pantalla Width";
    String valpd="Pantalla density";
    String valps="Pantalla size";
    String valpfr="Pantalla refresh rate";
    String valinf2="Almacenamiento Externo SD";
    String valinf3="Almacenamiento A2SD";
    String valinf4="Informacion de Pantalla";
    String valinf5="Soporte imagen camara trasera";
    String valinf6="Soporte video camara trasera";
    String valinf7="otras caracteristicas";
    String valinf8="Soporte imagen camara frontal";
    String valinf9="Soporte video camara frontal";
    String valinf10="Focus Mode Values";
    String valinf11="camaras";
    String valinf12="Soporte Flash";
    String valinf13="Almacenamiento Interno";
    String valinf14="Almacenamiento del Sistema";
    String valinf15="Caché del Sistema";
    String valinf16="Memoria";
    String valinf17="Procesador";
    String valinf18="Escalado de frecuencia de CPU";
    String valinf19="Red";
    String valinf20="Descripcion  Procesador";
    String valitem="item";
    String valdevi="device";
    String valappinstall="Aplicaciones";
    String valapdetect="detect";
    String apktoinstalled="apk";
    String apktochecks="update";
    String valappserver="server";
    String nbech="nt";
    String rbench="rt";
    String imgb="it";
    String disconnect="por algun motivo se ha desconectado el dispositivo";
    String noconnect="no se ha detectado dispositivo";
    String exrecord="dispositivo se encuentra registrado";
    String question="¿Desea ver los registros?";
    String question2="¿Desea continuar sin un dispositivo conectado?";
    String question1="¿Desea obtener la informacion para su uso?";
    String[] listvalues={"Dispositivo:","Almacenamiento Externo SD:","Almacenamiento A2SD:","Informacion de Pantalla:","Soporte imagen camara trasetra:",
    "Soporte video camara trasera:","otras caracteristicas:","Soporte imagen camara frontal:","Soporte video camara frontal:",
    "Focus Mode Values:","camaras:","Soporte Flash:","Almacenamiento Interno:","Almacenamiento del Sistema:","Caché del Sistema:",
    "Memoria:","Procesador:","Red:","Escalado de frecuencia de CPU:","Processor:"};
    String removefile="[|]|'|:|Dispositivo|Modelo|Producto|Marca|Release|Build|"
            + "Locale|Total|Disponible|height|width|density|Physical size|refresh rate|"
            + "soporte: '0 :|soporte: '1 :|soporte: '2 :|soporte: '3 :|soporte: '4 :|soporte: '5 :|"
            + "soporte: '6 :|soporte: '7 :|soporte: '8 :|soporte: '9 :|soporte: '10 :|soporte: '11 :|"
            + "soporte: '12 :|soporte: '13 :|soporte: '14 :|soporte: '15 :|soporte|Focus mode|"
            + "Max Num Focus Areas|Whitebalance Values|Scene mode Values|Stabilization Video|"
            + "Quality JPEG|Quality Thumbnail|Disponible|"
            + "numero disponibles|estatus|Idle|Features	:|CPU implementer	:|CPU architecture:|CPU variant	:|CPU part	:|CPU revision	:|Hardware	:|Revision	:|Serial		:|    |[|]";
    String[] otfeature={"Focus mode","Max Num Focus Areas","Whitebalance Values","Scene mode Values","Stabilization Video","Quality JPEG","Quality Thumbnail",null};
    String[] sup={"soporte resolución imagenes camara principal"};   
    String[] vidsup={"soporte resolución video camara principal"}; 
    String[] sup2={"soporte resolución imagenes camara secundaria"};   
    String[] vidsup2={"soporte resolución video camara secundaria"}; 
    String[] mod={"modo de foco cámara"};
    String[] cams={"numero de cámaras disponibles"};
    String[] est={"estatus flash"};
    String[] dispcache={"Caché del Sistema Total","Caché del Sistema Disponible",null,};
    String[] alminter={"Almacenamiento Interno Total","Almacenamiento Interno Disponible",null,};
    String[] almsis={"Almacenamiento del Sistema Total","Almacenamiento del Sistema Disponible",null,};
    String[] dispm={"Memoria RAM Total","Memoria RAM Disponible","Memoria RAM Idle",null,null};
    String[] proc={"Tipo CPU",null,null};
    String[] frec={"Frecuencia CPU",null,null};
    String[] red={"Red",null,null};
    String[] profeature={"Caracteristicas","CPU implementador","CPU arquitectura","CPU variante","CPU parte","CPU revision","Hardware","Revision","Serial",null};
    String stest="select * from user";
    String[] capturedis={"adb shell screencap -p /storage/sdcard0/app-siragon/captures/",".png"};
    String[] consults={"select name_mat from material","select val_net from network where type_net='mobile'",
      "select val_net from network where type_net='wifi'","select type_blu from bluetooth",
      "select * from display_type","select * from display_tactil","select * from battery",
      "select name_sup from other_support where type='sensor'","select name_provider from provider","select name_test from test"};
    String[] columnsdb={"name_mat","val_net","type_blu","name_dis","name_tactil",
      "type_bat","name_sup","name_provider","name_test"};
    String[] mesagges={"por favor conecte un dispositivo a traves de USB.","dispositivo se encuentra registrado",
        "error al conectar con servidor de datos","tabla ya posee datos de un equipo",
        "instalando aplicación ","ha finalizado la prueba correctamente, ingrese el resultado obtenido",
        "ingrese resultado de la prueba o agrege capturas de pantallas de la prueba"};
    String[] moveresultsappbench={"/data/data/com.antutu.ABenchMark/files/ranking.xml /storage/sdcard0/app-siragon/result-benchmark'"};
    String[] moveappbench={"adb shell su -c 'cp /data/app/com.antutu.ABenchMark-1.apk /storage/sdcard0/app-siragon/apk'"};
    String[] sendapptoPcbench={"adb pull /storage/sdcard0/app-siragon/apk C:\\application\\apps\\apk_benchmark"};
    String[] sendfiletoPcbench={"adb pull /storage/sdcard0/app-siragon/result-benchmark/ranking.xml C:\\application\\apps\\result_benchmark"};
    String[] apkbenchinstall={"com.antutu.ABenchMark-1.apk","com.quicinc.vellamo-1.apk","com.futuremark.dmandroid.application-2.apk"};
    String[] chantxtbt={"instalar aplicaciones","obtener aplicaciones","verificar aplicaciones"};
    String[] finishapp={"com.antutu.benchmark.UPDATE_ON_FINISHED","act=com.quicinc.vellamo.B_RESULTS",
        "AppLaunch_LaunchTime:com.futuremark.dmandroid.application/.activity.MainActivity",
        "Displayed Displayed com.primatelabs.geekbench/.BenchmarkDocumentActivity"};
    String[] pathfilebench={"C:\\application\\apps\\result_benchmark\\ranking.xml"};
    String[] stopapp={"adb shell am force-stop com.antutu.ABenchMark"};
    
}
