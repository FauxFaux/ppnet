
#!/bin/sh
a=0
b=0
c=1
echo -n " Directory:"
read Direct

for counter in $*
do

(xterm -hold  -e sh /home/tai/Bureau/gatling-charts-highcharts-bundle-2.2.2/bin/gatling.sh -s $counter -on $Direct$a )& 

#(sh /home/tai/Bureau/gatling-charts-highcharts-bundle-2.2.2/bin/gatling.sh -s $2 -on $3$a) 
let "a=a+1"
done
wait
index=*
cd /home/tai/Bureau/gatling-charts-highcharts-bundle-2.2.2/results/$Direct$b$index

enter=$(awk -F" " '{ if($1!="USER" && $1!="ASSERTION" && $1!="RUN" && $5=="send") print $6}' simulation.log)
ina="init2:"
StartValue=$(awk -F" " '{ if($4=="Typing" && $5=="ok") print $7}' simulation.log)
echo $ina$StartValue



cd /home/tai/Bureau/gatling-charts-highcharts-bundle-2.2.2/results/$Direct$c$index

final=$(awk -F" " '{ if($1!="USER" && $1!="ASSERTION" && $1!="RUN" && $4=="Receive") print $7}' simulation.log)
echo $final > final.txt
init="init:"
FinalValue=$(awk -F" " '{ if($5=="sender") print $6}' simulation.log)
echo $init$FinalValue

value="Init value: "
echo $value$enter
valu="Final value: "
echo $valu$final
counter=$(grep -o ' ' final.txt| wc -l)
let "counter=counter+1"
echo $valu$counter
arr=(${final// / })
arr2=(${enter// / })
arr3=(${StartValue// /})
arr4=(${FinalValue// /})
#for index in  "${arr[@]}";
#do
for i in ${!arr[*]};
do


#echo "${arr[$i]}";
#echo $value;
#echo "${arr2[$i]}";
FinaleValue=${arr[$i]};
StarteValue=${arr2[$i]};
Finale=${arr4[$i]};
Starte=${arr3[$i]};
let "diff=FinaleValue-StarteValue";
let "var=Finale-Starte";
let "fin=var-diff"
Latence="Latency: "

echo $var;
echo $diff;
echo $Latence$fin;
done
#done




