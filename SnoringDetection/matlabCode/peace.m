%% »¬¶¯ÂË²¨Æ÷Éè¼Æ
function pea = peace(seq,m)
   [A, B]= size(seq);
   pea = zeros(A,B);
   ped = ones(1,m)/m;
   for i=1:A
   tempea = conv(ped,seq(i,:));
   pea(i,:) = [seq(i,1:m-1),tempea(m:length(seq))];
   end
end
