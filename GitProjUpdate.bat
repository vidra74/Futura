D: > D:\gitUpdateLiveScorer.txt

echo "Sredi android mobilni projekt" >> D:\gitUpdateLiveScorer.txt

cd "D:\GitHub\Futura\liveScorer" >> D:\gitUpdateLiveScorer.txt

call ..\GitProjDel.bat

cd "D:\Android\Workspace\liveScorer" >> D:\gitUpdateLiveScorer.txt

copy *.* "D:\GitHub\Futura\liveScorer" >> D:\gitUpdateLiveScorer.txt

xcopy "D:\Android\Workspace\liveScorer\res" "D:\GitHub\Futura\liveScorer\res\" /S /Q >> D:\gitUpdateLiveScorer.txt
xcopy "D:\Android\Workspace\liveScorer\src" "D:\GitHub\Futura\liveScorer\src\" /S /Q >> D:\gitUpdateLiveScorer.txt
xcopy "D:\Android\Workspace\liveScorer\gen" "D:\GitHub\Futura\liveScorer\gen\" /S /Q >> D:\gitUpdateLiveScorer.txt

cd "D:\GitHub\Futura\liveScorer" >> D:\gitUpdateLiveScorer.txt

dir >> D:\gitUpdateLiveScorer.txt 

cd "D:\GitHub\Futura" >> D:\gitUpdateLiveScorer.txt

echo "Sredi ReadMe.txt" >> D:\gitUpdateLiveScorer.txt

notepad ReadMe.txt >> D:\gitUpdateLiveScorer.txt

notepad D:\gitUpdateLiveScorer.txt