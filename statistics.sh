#!/usr/bin/env bash
echo Raw Lines Contributed:
git ls-files | while read f; do git blame -w -M -C -C --line-porcelain "$f" | grep -I '^author '; done | sort -f | uniq -ic | sort -n --reverse
echo ----
echo Commits Contributed:
git shortlog -sn
