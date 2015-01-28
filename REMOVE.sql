#insert into cpu values (2,'dddd','dddd',1,'dddd','dddd','dddd','dddd')
#select * from cpu where name_cpu='dddd'
#select count(id_cpu) from cpu
#insert into device_cpu values ('SP-5110',1)
#select id_cpu from cpu where name_cpu='dddd' 
#select * from device_cam where id_dev_cam='SP-5110'
#select id_mat from material where name_mat='plastico'
#insert into device_mat values ('')
delete from display where i_dev='SP-5110';
delete from device_mat where id_dev_mat='SP-5110';
delete from device_support where id_dev='SP-5110';
delete from device_cpu where id_dev_cpu='SP-5110';
delete from device_cam where id_dev_cam='SP-5110';
delete from device_battery where id_dev_b='SP-5110';
delete from device_support where id_dev='SP-5110';
delete from device_network where id_dev='SP-5110';
delete from image where id_dev='SP-5110';
delete from device_failure where id_dev='SP-5110';
delete from device where id_device='SP-5110';
#select count(id_image) as t from image
#insert into device_failure values(1,'SP-5110','dsf','defge',0,'2014-02-09',0)
#select count(id_img) from image
#insert into image values(1,'0123456789ABCDEF','dsfdgf','2012-09-09','C:\application\img\fails\51907442.png')
#select count(id_image) as t from image
#select id_test as n from test where name_test='twitter'
#insert into device_test values(1,'0123456789ABCDEF',1,'N/A',0,0,0,0,0)
#select * from test
#insert into cpu values (2,'dddd','dddd',1,'dddd','dddd','dddd','dddd')
#select * from cpu where name_cpu='dddd'
#select count(id_cpu) from cpu
#insert into device_cpu values ('SP-5110',1)
#select id_cpu from cpu where name_cpu='dddd' 
#select * from device_cam where id_dev_cam='SP-5110'
#select id_mat from material where name_mat='plastico'
#insert into device_mat values ('')
#delete from display where i_dev='SP-5110';
#delete from device_mat where id_dev_mat='SP-5110';
#delete from device_support where id_dev='SP-5110';
#delete from device_cpu where id_dev_cpu='SP-5110';
#delete from device_cam where id_dev_cam='SP-5110';
#delete from device_battery where id_dev_b='SP-5110';
#delete from device_support where id_dev='SP-5110';
#delete from device_network where id_dev='SP-5110';
#delete from image where id_dev='SP-5110';
#delete from device_failure where id_dev='SP-5110';
#delete from device where id_device='SP-5110';
#select count(id_image) as t from image
#insert into device_failure values(1,'SP-5110','dsf','defge',0,'2014-02-09',0)
#select count(id_img) from image
#insert into image values(1,'0123456789ABCDEF','dsfdgf','2012-09-09','C:\application\img\fails\51907442.png')
#select count(id_image) as t from image
#select id_test as n from test where name_test='twitter'
#insert into device_test values(1,'0123456789ABCDEF',1,'N/A',0,0,0,0,0)
#select name_test from test where name_test!='antutu'
#select file_img as t from image where type_img='falla' && id_dev in(select id_dev from device_failure where id_dev='0123456789ABCDEF') 
#select file_img as t from image where type_img='falla' && id_dev in(select id_dev from device_failure where id_dev='0123456789ABCDEF') 
#select id_image from image
#select id_dev from image where file_img like'%473954748.png'
#select id_img_fail as t from device_failure where id_img_fail=(select id_image from image where type_img='falla' and file_img like'%948483646.png')
#select id_img_test from device_test where id_img_test=(select id_image from image where type_img='test' and file_img like'%697859855.png')
#select id_image from image where type_img='dispositivo' and file_img like'%DSC0001.JPG'
#select id_image from image where type_img='dispositivo' and file_img like'%316143380.png'
#select * from device_failure
#delete from device_failure where id_fail=4
#select id_fail from device_failure where id_img_fail=1 and name_fail='qweqdasf' and desc_fail='adfasdfsdfssdf'
#select nvalues as t from params where nparams='año'
#select id_device from device,cpu where id_cpu=(select id_cpu_c from device_cpu where core_cpu='4')
#select id_dev_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_dev_test in(select id_device from device where id_device='SP-5110') 
#select id_device from device
#select id_device,ram_t from device where id_device=('SP-5110')
#select id_device,sto_inter_t from device where id_device=('SP-5110')
#select id_device as t from device,device_cpu where id_dev_cpu=id_device and id_cpu_c in(select id_cpu from cpu where core_cpu=2)
#select name_sup from other_support where id_sup in(select id_sup from device_support where id_dev='SP-5110')
#select other_support.name_sup from other_support,device_support where name_sup='Magnetómetro' and other_support.id_sup=device_support.id_sup and id_dev in(select id_device from device,device_support where id_device=id_dev and id_device='SP-5110')
#select val_net as t from device,device_network,network where type_net='wifi' and val_net='802.11b' and id_device=id_dev and id_net=net_dev and id_device='SP-5110'
#select core_cpu from cpu,device_cpu,device where id_cpu=id_cpu_c and id_device=id_dev_cpu and id_device='SP-5110' 
#select x_dis as t from display,display_tactil,display_type,device where id_device=i_dev and id_dis=id_type_dis and type_tac=id_tactil and id_device='SP-5110'
#select mp_cam as t from device_cam,device where type_cam='primary' and id_device=id_dev_cam and id_device='SP-5110'
#insert into cpu values (2,'dddd','dddd',1,'dddd','dddd','dddd','dddd')
#select * from cpu where name_cpu='dddd'
#select count(id_cpu) from cpu
#insert into device_cpu values ('SP-5110',1)
#select id_cpu from cpu where name_cpu='dddd' 
#select * from device_cam where id_dev_cam='SP-5110'
#select id_mat from material where name_mat='plastico'
#insert into device_mat values ('')
#delete from display where i_dev='SP-5110';
#delete from device_mat where id_dev_mat='SP-5110';
#delete from device_support where id_dev='SP-5110';
#delete from device_cpu where id_dev_cpu='SP-5110';
#delete from device_cam where id_dev_cam='SP-5110';
#delete from device_battery where id_dev_b='SP-5110';
#delete from device_support where id_dev='SP-5110';
#delete from device_network where id_dev='SP-5110';
#delete from image where id_dev='SP-5110';
#delete from device_failure where id_dev='SP-5110';
#delete from device where id_device='SP-5110';
#select count(id_image) as t from image
#insert into device_failure values(1,'SP-5110','dsf','defge',0,'2014-02-09',0)
#select count(id_img) from image
#insert into image values(1,'0123456789ABCDEF','dsfdgf','2012-09-09','C:\application\img\fails\51907442.png')
#select count(id_image) as t from image
#select id_test as n from test where name_test='twitter'
#insert into device_test values(1,'0123456789ABCDEF',1,'N/A',0,0,0,0,0)
#select name_test from test where name_test!='antutu'
#select file_img as t from image where type_img='falla' && id_dev in(select id_dev from device_failure where id_dev='0123456789ABCDEF') 
#select file_img as t from image where type_img='falla' && id_dev in(select id_dev from device_failure where id_dev='0123456789ABCDEF') 
#select id_image from image
#select id_dev from image where file_img like'%473954748.png'
#select id_img_fail as t from device_failure where id_img_fail=(select id_image from image where type_img='falla' and file_img like'%948483646.png')
#select id_img_test from device_test where id_img_test=(select id_image from image where type_img='test' and file_img like'%697859855.png')
#select id_image from image where type_img='dispositivo' and file_img like'%DSC0001.JPG'
#select id_image from image where type_img='dispositivo' and file_img like'%316143380.png'
#select * from device_failure
#delete from device_failure where id_fail=4
#select id_fail from device_failure where id_img_fail=1 and name_fail='qweqdasf' and desc_fail='adfasdfsdfssdf'
#select nvalues as t from params where nparams='año'
#select id_device from device,cpu where id_cpu=(select id_cpu_c from device_cpu where core_cpu='4')
#select id_dev_test,result_test1,result_test2,result_test3,result_test4,result_test5 from device_test where id_dev_test in(select id_device from device where id_device='SP-5110') 
#select id_device from device
#select id_device,ram_t from device where id_device=('SP-5110')
#select id_device,sto_inter_t from device where id_device=('SP-5110')
#select id_device as t from device,device_cpu where id_dev_cpu=id_device and id_cpu_c in(select id_cpu from cpu where core_cpu=2)
#select name_sup from other_support where id_sup in(select id_sup from device_support where id_dev='SP-5110')
#select other_support.name_sup from other_support,device_support where name_sup='Magnetómetro' and other_support.id_sup=device_support.id_sup and id_dev in(select id_device from device,device_support where id_device=id_dev and id_device='SP-5110')
#select val_net as t from device,device_network,network where type_net='wifi' and val_net='802.11b' and id_device=id_dev and id_net=net_dev and id_device='SP-5110'
#select core_cpu from cpu,device_cpu,device where id_cpu=id_cpu_c and id_device=id_dev_cpu and id_device='SP-5110' 
#select x_dis as t from display,display_tactil,display_type,device where id_device=i_dev and id_dis=id_type_dis and type_tac=id_tactil and id_device='SP-5110'
#select mp_cam as t from device_cam,device where type_cam='primary' and id_device=id_dev_cam and id_device='SP-5110' 
#select capacity from battery,device,device_battery where id_device=id_dev_b and battery.id_bat=device_battery.type_bat and id_device='SP-5110'
#select color from device where id_device='SP-5110'
#select battery.type_bat as t from battery,device,device_battery where id_device=id_dev_b and battery.id_bat=device_battery.type_bat and id_device='SP-5110'
#select name_mat from material,device_mat,device where name_mat='plastico' and id_dev_mat = id_device and id_mat=id_mate and id_device='SP-5110'
#select name_provider from provider,device,device_provider where id_device=id_dev_prov and id_provider=id_prov and id_device='SP-5110'
#select file_img from image,device where type_img='test' and id_dev=id_device and id_image=12 and id_dev='SP-5110'
#select val_net from network where type_net='mobile'

