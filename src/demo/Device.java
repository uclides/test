/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author project
 */
public class Device {
  public final SimpleStringProperty device,model,product,make,release,build,
          locale,kernel,extstosd,stoa2sd,pheight,pwidth,pdensity,pphysize,
          prefrate;
  
  private Device(String sdevice,String smodel, String sproduct,String smake,
          String srelease,String sbuild,String slocale, String skernel,String sextstosd,
          String sstoa2sd,String spheight,String spwidth, String spdensity, String spphysize,
          String sprefrate){
      
   this.device=new SimpleStringProperty(sdevice);
   this.model=new SimpleStringProperty(smodel);
   this.product=new SimpleStringProperty(sproduct);
   this.make=new SimpleStringProperty(smake);
   this.release=new SimpleStringProperty(srelease);
   this.build=new SimpleStringProperty(sbuild);
   this.locale=new SimpleStringProperty(slocale);
   this.kernel=new SimpleStringProperty(skernel);
   this.extstosd=new SimpleStringProperty(sextstosd);
   this.stoa2sd=new SimpleStringProperty(sstoa2sd);
   this.pheight=new SimpleStringProperty(spheight);
   this.pwidth=new SimpleStringProperty(spwidth);
   this.pdensity=new SimpleStringProperty(spdensity);
   this.pphysize=new SimpleStringProperty(spphysize);
   this.prefrate=new SimpleStringProperty(sprefrate);
  }
  public String getDevice(){
  return device.get();
  }
  public void setDevice(String fdevice){
  device.set(fdevice);
  }
  public String getModel(){
  return model.get();
  }
  public void setModel(String fmodel){
  model.set(fmodel);
  }
  public String getProduct(){
  return model.get();
  }
  public void setProduct(String fproduct){
  this.product.set(fproduct);
  }
  public String getMake(){
  return make.get();
  }
  public void setMake(String fmake){
  this.make.set(fmake);
  }
  public String getRelease(){
  return release.get();
  }
  public void setRelease(String frelease){
  this.release.set(frelease);
  }
  public String getBuild(){
      return build.get();
  }
  public void setBuild(String fbuild){
  this.build.set(fbuild);
  }
  public String getLocale(){
  return locale.get();
  }
  public void setLocale(String flocale){
  this.locale.set(flocale);
  }
  public String getKernel(){
  return kernel.get();
  }
  public void setKernel(String fkernel){
  this.kernel.set(fkernel);
  }
  public String getExtstosd(){
  return extstosd.get();
  }
  public void setExtstosd(String fextstosd){
  this.extstosd.set(fextstosd);
  }
  public String getStoa2sd(){
  return stoa2sd.get();
  }
  public void setStoa2sd(String stoa2sd){
  this.stoa2sd.set(stoa2sd);
  }  
  public String getPheight(){
  return pheight.get();
  }
  public void setPheight(String fpheight){
  this.pheight.set(fpheight);
  }
  public String getPwidth(){
      return pwidth.get();
  }
  public void setPwidth(String fpwidth){
  this.pwidth.set(fpwidth);
  }
  public String getPdensity(){
  return pdensity.get();
  }
  public void setPdensity(String fpdensity){
  this.pdensity.set(fpdensity);
  }
  public String getPphysize(){
  return pphysize.get();
  }
  public void setPphysize(String fpphysize){
  this.pphysize.set(fpphysize);
  }
  public String getPrefrate(){
  return prefrate.get();
  }
  public void setPrefrate(String fprefrate){
  this.prefrate.set(fprefrate);
  }
}
