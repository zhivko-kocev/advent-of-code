const recs: number[][] = [];

for await (const line of console) {
  if (line.length == 0) break;

  const lvls = line.split(/\s+/).map((el) => parseInt(el));
  recs.push(lvls);
}

const isSafe = (rec: number[]) => {
  const isValid = (a: number, b: number) => a - b >= 1 && a - b <= 3;

  const windows = Array.from({ length: rec.length - 2 + 1 }, (_, i) =>
    rec.slice(i, i + 2)
  );
  return (
    windows.every((pair) => isValid(pair[0], pair[1])) ||
    windows.every((pair) => isValid(pair[1], pair[0]))
  );
};

const fixedAndSafe = (rec: number[]) => {
  for (let i = 0; i < rec.length; i++) {
    const reducedLevels = rec.filter((_, index) => index !== i);
    if (isSafe(reducedLevels)) {
      return true;
    }
  }
  return false;
};
console.log(recs.filter((el) => fixedAndSafe(el)).length);
