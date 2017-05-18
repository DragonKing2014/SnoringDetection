%获得数据库连接
conn = database('ibook', 'root', '595322101asd', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3305/ibook');
%获得当前系统时间
currentTime=datestr(now,31);

%滑动滤波，低通滤波
[y,Fs] = audioread('m0.mp3');
mytest = resample(y,8000,Fs);
[N,Wc]=buttord(0.1,0.15,1,30);
[b,a]=butter(N,Wc);
temp=mytest(:,1)';
temp=abs(temp);
temp1=peace(temp,5);
[m,l]=max(temp1);
temp1=temp./m;
temp2 = 2*filter(b,a,temp1);

%调用端点检测函数
surplus=temp2';
endTime=0;

while(length(surplus)>1000)
    %输入长度
    inputLength=length(surplus);
    %vad取下一个有能量片段
    [vadSnore,surplus]=vad(surplus);
    %剩余长度
    surplusLength=length(surplus);
    %类鼾声片段的长度
    duration=length(vadSnore);
    %终止时间点
    endTime=endTime+(inputLength-surplusLength);
    %起始时间点
    startTime=endTime-duration;
    %向数据库插入数据
    if(duration/8000>0.6)
        insert(conn,'snore',{'startTime','endTime','duration','dateTime','meanValue','maximumValue'},...
            {startTime,endTime,duration,currentTime,mean(vadSnore),max(vadSnore)});
    end
end


figure(1)
subplot(3,1,1);
plot(temp2);
subplot(3,1,2);
plot(surplus);
subplot(3,1,3);
plot(vadSnore);


