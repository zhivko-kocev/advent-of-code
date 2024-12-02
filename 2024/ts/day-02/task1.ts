const recs: number[][] = [];

for await (const line of console) {
  if (line.length == 0) break;

  const lvls = line.split(/\s+/).map((el) => parseInt(el));
  recs.push(lvls);
}

const isValid = (a: number, b: number) => a - b >= 1 && a - b <= 3;

const isSafe = (rec: number[]) => {
  const windows = Array.from({ length: rec.length - 2 + 1 }, (_, i) =>
    rec.slice(i, i + 2)
  );
  return (
    windows.every((pair) => isValid(pair[0], pair[1])) ||
    windows.every((pair) => isValid(pair[1], pair[0]))
  );
};

console.log(recs.filter((el) => isSafe(el)).length);
