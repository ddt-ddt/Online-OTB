# execute the hadoop job in this file
# We should set: 1. the IP of the virtual cluster's master
#		 2. the hadoop path
#		 3. the command of executing the job
#		 4. the arriving time

node1="192.168.130.1"
node2="192.168.130.2"
node3="192.168.130.10"
node4="192.168.130.3"
node5="192.168.130.6"
node6="192.168.130.7"
node7="192.168.130.9"
node8="192.168.130.8"
node9="192.168.130.12"
node10="192.168.130.11"

ssh $node1 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar wordcount data29.txt output2"

sleep 500s

ssh $node2 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar wordcount data29.txt output2"

sleep 500s

ssh $node3 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar wordcount data6.4.txt output1"

sleep 500s

ssh $node4 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar wordcount data6.4.txt output1"

sleep 500s

ssh $node5 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar sort rand rand-output"

sleep 500s

ssh $node6 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar terasort /user/terasort/3G-input 3G-output"

sleep 500s

ssh $node7 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar wordcount data6.4.txt output1"

sleep 500s

ssh $node8 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar wordcount data29.txt output2"

sleep 500s

ssh $node9 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar sort rand rand-output"

sleep 500s

ssh $node10 "cd /usr/local/hadoop/hadoop-1.1.0 && bin/start-mappred.sh && bin/hadoop jar hadoop-1.1.0-examples.jar sort rand rand-output"

