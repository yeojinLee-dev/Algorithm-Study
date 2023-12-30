dirname=`find . -name "[*"`
echo ${dirname:2}

git add "${dirname:2}"

today=`date`

git commit -m "${dirname:2} $today"
git push origin master

echo "> \n $today commit complete"


