#!/bin/sh
exec scala "$0" "$@"
!#

import java.util.Calendar

val xmas = Calendar.getInstance() 
xmas.set(Calendar.MONTH, Calendar.DECEMBER) 
xmas.set(Calendar.DAY_OF_MONTH, 7)

def secsUntilXmas: Long = (xmas.getTimeInMillis - System.currentTimeMillis) / 1000 / 60 / 60 / 24

println(s"Remaining days to my birthdate (7th of December): $secsUntilXmas")
