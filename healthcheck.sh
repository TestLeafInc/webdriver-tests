# Threshold (If the values go beyond these thresold - do not run automated tests)
Threshold_CPU=40
Threshold_Mem=45
Threshold_Disk=50

# Condition to allow or not allow to run
bPassed=true

# Memory Check
mem_value=$(free | grep Mem | awk '{print int($3/$2*100)}')
echo $mem_value 
if((mem_value > Threshold_Mem)); then
    echo 'Memory is running beyond your threshold'
    bPassed=false
fi

# CPU Check
cpu_value=$(top -n1 | grep 'Cpu' | awk '{print int($2)}')
echo $cpu_value 
if((cpu_value > Threshold_CPU)); then
    echo 'CPU is running beyond your threshold'
    bPassed=false
fi


# Disk Check
disk_value=$(df / | tail -1 | awk '{ gsub("%",""); print $5}')
echo $disk_value 
if((disk_value > Threshold_Disk)); then
    echo 'Disk is running beyond your threshold'
    bPassed=false
fi

# Check if the condition is false, terminate and do not run test 
if($bPassed); then
    echo "The automated tests can run now as the health check is positive"
    bash install-run.sh
fi

