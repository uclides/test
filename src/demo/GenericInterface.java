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
    String startSiragonapp="adb shell am start -n  org.uguess.android.sysinfo/.QSystemInfo";
    String pullfile="adb pull /sdcard/logs C:\\application\\deviceRegisters";
    String devicedisp="adb devices";
    String down="adb shell input keyevent 20";
    String web="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
   + " file:///C:/Users/Uclides Gil/Documents/NetBeansProjects/test/src/demo/manual/index.html";
    //pathsC:\Users\Uclides Gil\Documents\NetBeansProjects
    String folderegister="C:\\application\\deviceRegisters\\";
    //list message
    String detect="Dispositivo detectado";
    String company="Síragon";
    String emptyd="empty directory";
    String errorlogin="Username/Password is incorrect";
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
    String[] sup={"soporte"};
    String[] mod={"mode"};
    String[] cams={"numero disponibles"};
    String[] est={"estatus"};
    String[] disp={"Total","Disponible",null,};
    String[] dispm={"Total","Disponible","Idle",null,null};
    String[] proc={"Tipo",null,null};
    String[] profeature={"Caracteristicas","CPU implementador","CPU arquitectura","CPU variante","CPU parte","CPU revision","Hardware","Resivison","Serial",null};
  
}
