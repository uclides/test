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
    String installSiragonapp="adb install C:\\application\\apps\\siragonapp.apk";
    String startSiragonapp="adb shell am start -n  org.uguess.android.sysinfo/.SiragonInfo";
    String pullfile="adb pull /sdcard/logs C:\\application\\deviceRegisters";
    String devicedisp="adb devices";
    String removeFadb="adb shell rm /storage/sdcard0/ADB/*";
    String down="adb shell input keyevent 20";
    String web="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
   + " file:///C:/Users/Uclides Gil/Documents/NetBeansProjects/test/src/demo/manual/index.html";
    //pathsC:\Users\Uclides Gil\Documents\NetBeansProjects
    String server="C:\\Users\\project\\Desktop\\a.bat";
    String folderegister="C:\\application\\deviceRegisters\\";
    String folderLogs="C:\\application\\logs\\";
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
  String[] consults={"select name_mat from material","select val_net from network where type_net='mobile'",
      "select val_net from network where type_net='wifi'","select type_blu from bluetooth",
      "select * from display_type","select * from display_tactil","select * from battery",
      "select name_sup from other_support where type='sensor'","select name_provider from provider"};
  String[] columnsdb={"name_mat","val_net","type_blu","name_dis","name_tactil",
      "type_bat","name_sup","name_provider"};
  String[] mesagges={"por favor conecte un dispositivo a traves de USB.","dispositivo se encuentra registrado","error al conectar con servidor de datos","tabla ya posee datos de un equipo"};


}
