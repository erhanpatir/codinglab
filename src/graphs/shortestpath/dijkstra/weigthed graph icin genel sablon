7. Sana genel karar şablonu veriyorum

Bir weighted graph sorusu görünce kafadan şu checklist çalışsın:

A. Amaç ne?
    min mi?
    max mı?
    count mu?
    reachability mi?

B. State ne?
    node yeterli mi?
    aynı node'a farklı şekilde gelmek sonucu değiştirir mi?

C. best yapısı ne tutacak?
    best[state] = bu state için en iyi değer

D. PQ neye göre sıralanacak?
    minimize ediyorsam min-heap
    maximize ediyorsam max-heap

E. Transition ne?
    state -> nextState
    newValue = combine(currValue, edgeValue)


Bu 5 soru çözümün iskeletini çıkarır.


743
    Goal: min total time
    State: node
    Best: dist[node]
    PQ: (time, node)
    Transition: + edgeWeight
    Heap: min
1514
    Goal: max probability
    State: node
    Best: prob[node]
    PQ: (prob, node)
    Transition: * edgeProb
    Heap: max
787
    Goal: min total cost
    State: (city, remainingEdges)
    Best: best[city][remainingEdges]
    PQ: (cost, city, remainingEdges)
    Transition: + flightCost, remainingEdges - 1
    Heap: min

9. Asıl master cümle

Bunu gerçekten içselleştir:

    Array, node için değil state için tutulur.
    PQ da node değil state taşır.

10. Hızlı zihinsel template

Soruyu görünce kafanda şu formatı doldur:

1) Graph type:
   directed / undirected
   weighted / unweighted

2) Optimization:
   min / max / reachability

3) State:
   node
   or (node, extra)

4) Best structure:
   best[state]

5) DS:
   BFS queue / min-heap / max-heap

6) Transition:
   how do I go to neighbor?
   how do I update value?

11. Sana bir kısa ezber haritası
    Unweighted shortest path
    → state = node
    → queue
    → dist[node]

    Weighted min path
    → state = node
    → minHeap
    → dist[node]

    Weighted max path
    → state = node
    → maxHeap
    → best[node]

    Weighted + constraint
    → state = (node, constraint)
    → heap or DP
    → best[node][constraint]