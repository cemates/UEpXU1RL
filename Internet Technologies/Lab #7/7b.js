const fs = require('fs');

function watchDir() {
  if (process.argv[2] === undefined) {
    console.log('please provide dir path as parameter');
    return;
  }
  let dirPath = process.argv[2];
  fs.lstat(process.argv[2], (err, stats) => {
    if (err) {
      if (err.code === 'ENOENT') {
        console.error('File or directory with such name does not exist');
        return;
      }
      throw err;
    }
    if (stats.isDirectory()) {
      console.log('Watching for changes in directory ' + dirPath);
    }
    if (stats.isFile()) {
      console.log('Watching for changes in file ' + dirPath);
    }
  })

  fs.watch(dirPath, {
    recursive: true
  }, (eventType, filename) => {
    console.log(filename + ' was ' + eventType + 'd');
  });
}
watchDir();
