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
   + " file:///C:/Users/project/Documents/GitHub/test/src/demo/manual/index.html";
    //paths
    String folderegister="C:\\application\\deviceRegisters";
    //list message
    String detect="Dispositivo detectado";
    String company="Síragon";
    String emptyd="empty directory";
    String errorlogin="Username/Password is incorrect";
    
}
