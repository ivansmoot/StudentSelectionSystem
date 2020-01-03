--רҵ��D��רҵ����dno��רҵ����dn 
create table D(dno char(3) primary key,dn char(15) unique not null) select * from S insert into D values('001','js')

--��ʦ��T����ʦ��tno������tn���Ա�tsex����ְ��ty������tp��רҵ����dno
create table T(tno char(9) primary key,tn char(8),tsex char(2) check(tsex in('��','Ů')),ty int check(ty between 2000 and 2018),
tp char(8),dno char(3) foreign key references D(dno))

--ѧ����S��ѧ��sno������sn���Ա�ssex����ѧ��sy������sp��רҵ����dno
create table S(sno char(7) primary key,sn char(8),ssex char(2) check(ssex in('��','Ů')),sy int check(sy between 2000 and 2018),
sp char(8),dno char(3) foreign key references D(dno))

--�γ̱�C���γ̺�cno���γ���cn��ѧ��cs��ѧʱcp������cc��רҵ����dno ,���� n,
create table C(cno char(12) primary key,cn char(30) not null,cs float check(cs between 0.5 and 10),cp int check(cp between 20 and 80),
cc int check(cc between 0 and 1) ,dno char(3) foreign key references D(dno),n int default 0) 

--�ڿι�ϵ��TC����ʦ��tno���γ̺�cno,ѧ��sy,ѧ��term
create table TC(tno char(9) foreign key references T(tno),cno char(12) foreign key references C(cno),sy int,term int not null,primary key(tno,cno))

--ѡ�ι�ϵ��SC��ѧ��sno���γ̺�cno���ɼ�score��syѧ�꣬ѧ��term
create table SC(sno char(7) foreign key references S(sno),cno char(12) foreign key references C(cno),score float,primary key(sno,cno),sy int ,term int )

--��ѧ�ƻ���TP��ѧ��sy,ѧ��term,�꼶sy1,רҵdn,�γ̺�cno,ѧ��cs,ѧʱ cp,���۽�ѧѧʱ cp1,ʵ��/ʵ��ѧʱ cp2,�ϻ�ѧʱ cp3,ÿ��ѧʱ cp4
create table TP(sy int not null ,term int not null,sy1 int, dno char(15) not null, cno char(12) foreign key references C(cno),
cs float check(cs between 0.5 and 10) not null ,cp int check(cp between 20 and 80 ) not null,cp1 int check(cp1 between 0 and 80),
cp2 int check(cp2 between 0 and 80),cp3 int check(cp3 between 0 and 80),cp4 int check(cp4 between 2 and 6) not null) 

---�α�CTimetable,ѧ��sy,ѧ��term,�꼶sy1,רҵdno,�γ̺�cno,��ʼ��week1,������week2������1weekday1,����2weekday2,����1section1,����2section2
create table CTimetable(sy int not null,term int not null,sy1 int, dno char(15) not null,cno char(12)  foreign key references C(cno),
tno char(9) foreign key references T(tno),week1 char(12) ,week2 char(12),weekday1 char(9),weekday2 char(9),section1 char(9),section2 char(9)) 

--ʱ��� t_ime, �γ̺�cno��רҵ��dno(���ĸ�רҵ�ϵ�)��ѧ��_year��ѧ��term
create table t_ime(cno char(12),dno char(3),_year int,term int,primary key(cno,dno))

--����Ա��
create table M(Username char(10) primary key,password char(10) not null,Name char(10) not null)
insert into M values('admin','password','name')
delete sc


--������TC_SC
go
create Trigger TC_SC   
on TC 
for insert 
as
begin
insert into SC(sno,cno,sy,term) select sno,inserted.cno,inserted.sy,term from S,inserted where S.dno='CS' 
end
go

--������TP_CT_insert
drop trigger TP_CT_insert
go
create Trigger TP_CT_insert
on TP
for insert 
as
begin
insert into CTimetable(sy,term,dno,cno) select sy,term,dno,cno from inserted where dno='CS';
end
go

--ɾ��������TP_CT_delete
go
create Trigger TP_CT_delete
on TP
for delete
as 
begin
delete from CTimetable where sy in(select sy from deleted) and term in(select term from deleted) and dno in(select dno from deleted)
and cno in(select cno from deleted ) 
end
go

--�鿴���д�����
drop trigger TC_SC
delete from TP
delete from CTimetable
delete from TC
select * from SC
select name from sysobjects where xtype='TR'
select * from TP
select * from CTimetable

	
	 
insert into D values('001','�����')
insert into D values('002','���')
insert into D values('003','�г�Ӫ��')
insert into D values('004','�ǹ�')
insert into D values('005','����')

insert into T values('000000001','��ʦ1','��','2000','00000000','001')
insert into T values('000000002','��ʦ2','��','2001','00000000','001')
insert into T values('000000003','��ʦ3','Ů','2013','00000000','001')
insert into T values('000000004','��ʦ4','Ů','2004','00000000','001')
insert into T values('000000005','��ʦ5','Ů','2018','00000000','001')

insert into T values('000000006','��ʦ6','��','2005','00000000','002')
insert into T values('000000007','��ʦ7','��','2002','00000000','002')
insert into T values('000000008','��ʦ8','Ů','2005','00000000','002')
insert into T values('000000009','��ʦ9','Ů','2001','00000000','002')
insert into T values('000000010','��ʦ10','Ů','2011','00000000','002')

insert into T values('000000011','��ʦ11','��','2017','00000000','003')
insert into T values('000000012','��ʦ12','��','2003','00000000','003')
insert into T values('000000013','��ʦ13','Ů','2004','00000000','003')
insert into T values('000000014','��ʦ14','Ů','2018','00000000','003')
insert into T values('000000015','��ʦ15','Ů','2011','00000000','003')

insert into T values('000000016','��ʦ16','��','2003','00000000','004')
insert into T values('000000017','��ʦ17','��','2002','00000000','004')
insert into T values('000000018','��ʦ18','Ů','2001','00000000','004')
insert into T values('000000019','��ʦ19','Ů','2002','00000000','004')
insert into T values('000000020','��ʦ20','Ů','2013','00000000','004')

insert into T values('000000021','��ʦ21','��','2006','00000000','005')
insert into T values('000000022','��ʦ22','��','2007','00000000','005')
insert into T values('000000023','��ʦ23','Ů','2002','00000000','005')
insert into T values('000000024','��ʦ24','Ů','2009','00000000','005')
insert into T values('000000025','��ʦ25','Ů','2012','00000000','005')

insert into S values('0000001','ѧ��1','��','2016','00000000','001')
insert into S values('0000002','ѧ��2','��','2008','00000000','001')
insert into S values('0000003','ѧ��3','Ů','2002','00000000','001')
insert into S values('0000004','ѧ��4','Ů','2013','00000000','001')
insert into S values('0000005','ѧ��5','Ů','2010','00000000','001')

insert into S values('0000006','ѧ��6','��','2016','00000000','002')
insert into S values('0000007','ѧ��7','��','2008','00000000','002')
insert into S values('0000008','ѧ��8','Ů','2002','00000000','002')
insert into S values('0000009','ѧ��9','Ů','2013','00000000','002')
insert into S values('0000010','ѧ��10','Ů','2010','00000000','002')

insert into S values('0000011','ѧ��11','��','2016','00000000','003')
insert into S values('0000012','ѧ��12','��','2008','00000000','003')
insert into S values('0000013','ѧ��13','Ů','2002','00000000','003')
insert into S values('0000014','ѧ��14','Ů','2013','00000000','003')
insert into S values('0000015','ѧ��15','Ů','2010','00000000','003')

insert into S values('0000016','ѧ��16','��','2016','00000000','004')
insert into S values('0000017','ѧ��17','��','2008','00000000','004')
insert into S values('0000018','ѧ��18','Ů','2002','00000000','004')
insert into S values('0000019','ѧ��19','Ů','2013','00000000','004')
insert into S values('0000020','ѧ��20','Ů','2010','00000000','004')

insert into S values('0000021','ѧ��21','��','2016','00000000','005')
insert into S values('0000022','ѧ��22','��','2008','00000000','005')
insert into S values('0000023','ѧ��23','Ů','2002','00000000','005')
insert into S values('0000024','ѧ��24','Ů','2013','00000000','005')
insert into S values('0000025','ѧ��25','Ů','2010','00000000','005')

insert into C values('000000000001','�ߵ���ѧ','5','48','1','001','0')
insert into C values('000000000002','C++','3','36','1','002','0')
insert into C values('000000000003','��ͼ','1','25','1','003','0')
insert into C values('000000000004','��ѧ����','3','20','0','004','0')
insert into C values('000000000005','ë��','2','54','0','005','0')

insert into TC values('000000001','000000000001','2017','1')
insert into TC values('000000002','000000000001','2016','1')
insert into TC values('000000003','000000000001','2017','2')
insert into TC values('000000004','000000000001','2018','1')
insert into TC values('000000005','000000000001','2018','2')

insert into TC values('000000006','000000000002','2017','1')
insert into TC values('000000007','000000000002','2016','1')
insert into TC values('000000008','000000000002','2017','2')
insert into TC values('000000009','000000000002','2018','1')
insert into TC values('000000010','000000000002','2018','2')

insert into TC values('000000011','000000000003','2017','1')
insert into TC values('000000012','000000000003','2016','1')
insert into TC values('000000013','000000000003','2017','2')
insert into TC values('000000014','000000000003','2018','1')
insert into TC values('000000015','000000000003','2018','2')

insert into TC values('000000016','000000000004','2017','1')
insert into TC values('000000017','000000000004','2016','1')
insert into TC values('000000018','000000000004','2017','2')
insert into TC values('000000019','000000000004','2018','1')
insert into TC values('000000020','000000000004','2018','2')

insert into TC values('000000021','000000000005','2017','1')
insert into TC values('000000022','000000000005','2016','1')
insert into TC values('000000023','000000000005','2017','2')
insert into TC values('000000024','000000000005','2018','1')
insert into TC values('000000025','000000000005','2018','2')

insert into SC values('0000001','000000000001','80','2017','1') 
insert into SC values('0000001','000000000002','84','2016','1') 
insert into SC values('0000001','000000000003','58','2017','2') 
insert into SC values('0000001','000000000005','70','2018','1') 

insert into t_ime values('000000000001','002','2017','1')
insert into t_ime values('000000000002','001','2018','1')
insert into t_ime values('000000000003','003','2017','2')
insert into t_ime values('000000000004','004','2016','1')
insert into t_ime values('000000000005','005','2017','1')

insert into SC values('0000006','000000000005',79,'2017','1')
insert into SC values('0000006','000000000001',100,'2017','1')

insert into SC values('0000010','000000000001',80,'2017','1')
insert into SC values('0000010','000000000005',88,'2017','1')





