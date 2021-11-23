#!/bin/bash
cd lab0/
wc *s */*s */*/*s */*/*/*s -m 2>>/tmp/errors |  sort -r
ls -Rl 2>>/dev/null | grep "h$" | sort -r -k5 | head -n 3
cat d* */d* */*/d* */*/*/d* 2>&1 |  sort 
cat alakazam3/swampert alakazam3/dusclops 2>&1 | grep -i "e$" 
cat deino5/graveler deino5/solosis chandelure3/trubbish chandelure3/munchlax deino5/slowpoke 2>>/tmp/errors | grep -vi Mu
ls -Rl 2>>/tmp/errors | grep "3$" | sort -r -k5