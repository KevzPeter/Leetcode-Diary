class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        ret = []
        hm = dict()
        self.buildHashMap(paths, hm)
        return [v for v in hm.itervalues() if len(v)>1]

        
    def buildHashMap(self, paths, hm):
        for s in paths:
            tmpList = s.split()
            folder = tmpList[0]
            for i in xrange(1, len(tmpList)):
                fileName, fileContent = tmpList[i].split('(')
                fileContent = fileContent[:len(fileContent)-1]
                group = hm.setdefault(fileContent, [])
                group.append(folder + '/' + fileName)